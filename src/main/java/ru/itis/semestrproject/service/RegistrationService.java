package ru.itis.semestrproject.service;

import ru.itis.semestrproject.dto.DoctorDto;
import ru.itis.semestrproject.dto.PatientDto;
import ru.itis.semestrproject.models.Gender;

public interface RegistrationService {
    boolean register(DoctorDto form, Gender gender);
    boolean register(PatientDto form, Gender gender);
}
