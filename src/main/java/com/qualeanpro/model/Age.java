package com.qualeanpro.model;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)  // classe validateur
@Target({ ElementType.FIELD })                  // cible : ici un champ
@Retention(RetentionPolicy.RUNTIME)             // durée de vie : runtime
public @interface Age {

    String message() default "L'âge doit être entre {min} et {max} ans";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 18;    // âge minimum

    int max() default 60;    // âge maximum
}
