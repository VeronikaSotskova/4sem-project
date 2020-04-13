package ru.itis.semestrproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.semestrproject.dto.DoctorProfileDto;
import ru.itis.semestrproject.dto.PatientProfileDto;
import ru.itis.semestrproject.models.Account;
import ru.itis.semestrproject.models.AccountDetails;
import ru.itis.semestrproject.models.Doctor;
import ru.itis.semestrproject.models.Patient;
import ru.itis.semestrproject.service.AccountService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import static ru.itis.semestrproject.controllers.ControllerUtils.getErrors;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public String profile(Model model, @AuthenticationPrincipal AccountDetails account) {
        Doctor doctor = accountService.findDoctorByEmail(account.getUsername());
        Patient patient = accountService.findPatientByEmail(account.getUsername());

        if (doctor != null) {
            model.addAttribute("acc", doctor);
            model.addAttribute("type", "doctor");
        } else if (patient != null) {
            model.addAttribute("acc", patient);
            model.addAttribute("type", "patient");
        }
        return "profile";
    }

    @PostMapping("/doctor")
    public String updateDoctor(
            @Valid DoctorProfileDto form,
            BindingResult bindingResult,
            Model model,
            @AuthenticationPrincipal AccountDetails account
    ) {
        Doctor doctor = accountService.findDoctorByEmail(account.getUsername());
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrors(bindingResult);
            model.addAttribute("acc", doctor);
            model.addAttribute("type", "doctor");
            model.mergeAttributes(errors);
            return "profile";
        }

        accountService.updateDoctor(doctor, form);
        return "redirect:/profile";
    }

    @PostMapping("/patient")
    public String updatePatient(@Valid PatientProfileDto form,
                                BindingResult bindingResult,
                                Model model,
                                @AuthenticationPrincipal AccountDetails account

    ) {
        Patient patient = accountService.findPatientByEmail(account.getUsername());
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrors(bindingResult);
            model.addAttribute("acc", patient);
            model.addAttribute("type", "patient");
            model.mergeAttributes(errors);
            return "profile";
        }
        accountService.updatePatient(patient, form);
        return "redirect:/profile";
    }

    @PostMapping("/sendImage")
    public String editImage(@AuthenticationPrincipal AccountDetails acc, @RequestParam("file") MultipartFile file) throws IOException {
        saveFile(acc, file);
        return "redirect:/profile";
    }


    private void saveFile(AccountDetails user, MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));
            user.getAccount().setAvatarFilename(resultFilename);
            accountService.save(user.getAccount());
        }
    }
}
