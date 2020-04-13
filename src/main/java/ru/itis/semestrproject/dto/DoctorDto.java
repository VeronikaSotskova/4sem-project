package ru.itis.semestrproject.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.itis.semestrproject.constraints.AccountAgeConstraint;

import javax.validation.constraints.Digits;

@Data
@EqualsAndHashCode(callSuper = true)
public class DoctorDto extends AccountDto{

    @Digits(integer=2, fraction=0, message = "Не более 2-х знаков")
    @AccountAgeConstraint
    private Integer experience;
}
