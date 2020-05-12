package ru.itis.semestrproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.semestrproject.dto.ContactDto;
import ru.itis.semestrproject.models.Doctor;
import ru.itis.semestrproject.service.AccountService;
import ru.itis.semestrproject.service.DoctorService;
import ru.itis.semestrproject.service.MailSender;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private AccountService accountService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    public String secret(Model model) {
        return "home";
    }

    @GetMapping("/doctor-list")
    public String accList(Model model, @RequestParam(required = false) String filter) {
        List<Doctor> doctors = doctorService.filterDoctor(filter);
        model.addAttribute("doctors", doctors);
        model.addAttribute("nav_tab", "doctor_list");
        return "doctor_list";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = accountService.activateUser(code);

        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated.");

        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Activation code is not found.");
        }

        return "login";
    }

    @PostMapping("/sendReqAnon/to/{id}")
    public String sendMsgToDoctorAnon(@PathVariable Long id, ContactDto form, Model model) {
        Doctor doctor = doctorService.findById(id);
        String message = String.format(
                "Сообщение от %s: %s. \n Почта пользователя для ответа: %s.",
                form.getName(), form.getMessage(), form.getEmail()
        );
        mailSender.send(doctor.getEmail(), "Запрос", message);
        model.addAttribute("message", "Сообщение успешно отправлено");
        return "redirect:/doctor-list";
    }


}
