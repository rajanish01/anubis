package com.shopskill.anubis.configs.annotation;

import com.shopskill.anubis.configs.EnumValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull(message = "Value cannot be null")
@ReportAsSingleViolation
public @interface EnumValidator {

    Class<? extends Enum<?>> enumClazz();

    String message() default "No Enum Present For Given Value !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
