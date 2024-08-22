package ru.test.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BirthdayValidator implements ConstraintValidator<ValidBirthday, Object> {

    private String nameField;

    @Override
    public void initialize(ValidBirthday constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.nameField = constraintAnnotation.nameField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        LocalDate fieldValue = (LocalDate) new BeanWrapperImpl(value).getPropertyValue(nameField);
        if (fieldValue.isAfter(LocalDate.now())) {
            return false;
        }
        return true;
    }
}
