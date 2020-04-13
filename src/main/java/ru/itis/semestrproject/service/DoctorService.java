package ru.itis.semestrproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.semestrproject.exceptions.AccountNotFoundException;
import ru.itis.semestrproject.models.Doctor;
import ru.itis.semestrproject.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> filterDoctor(String filter) {
        if (filter != null && !filter.isEmpty()) {
            return doctorRepository.findBySearch(filter);
        } else {
            return doctorRepository.findAll();
        }
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(AccountNotFoundException::new);
    }

}
