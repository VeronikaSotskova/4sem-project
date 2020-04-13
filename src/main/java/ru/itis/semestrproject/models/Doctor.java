package ru.itis.semestrproject.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.itis.semestrproject.constraints.AccountAgeConstraint;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "doctor")
public class Doctor extends Account {


    @Digits(integer=2, fraction=0, message = "Не более 2-х знаков")
    private Integer experience;

    private String about;

    private Double score;

    @Override
    public Role getRole() {
        return Role.DOCTOR;
    }

    @Override
    String getType() {
        return "DOCTOR";
    }
}
