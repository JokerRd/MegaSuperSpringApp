package ru.test.backend.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = BirthdayValidator.class)
public @interface ValidBirthday {

    String message() default "Неправильный день рождения";

    String nameField() default "birthday";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
