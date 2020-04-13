package ru.itis.semestrproject.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountAgeConstraintValidator implements ConstraintValidator<AccountAgeConstraint, Integer> {

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        if (age == null) {
            return true;
        } else {
            return age > 0;
        }
    }
}
