package ru.itis.semestrproject.dto;

import lombok.Getter;
import lombok.Setter;
import ru.itis.semestrproject.constraints.AccountAgeConstraint;

import javax.validation.constraints.Digits;

@Getter
@Setter
public class DoctorProfileDto extends ProfileDto {

    @Digits(integer=2, fraction=0, message = "Не более 2-х знаков")
    private Integer experience;

    private String about;

    public DoctorProfileDto(String name, String surname, String patronymic, String email, Integer age, Integer experience, String about) {
        super(name, surname, patronymic, email, age);
        this.experience = experience;
        this.about = about;
    }
}
