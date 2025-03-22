package com.circulosiete.curso.funcional.clase11;

import io.vavr.Tuple;
import io.vavr.control.Option;
import io.vavr.control.Validation;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

public class Lab01 {
    private static final ValidatorFactory factory = jakarta.validation.Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> Validation<String, T> validate(T object) {
        return Option.of(object)
            .map(o -> Tuple.of(o, validator.validate(o)))
            .map(data -> buildValidationError(data._1, data._2))
            .getOrElse(Validation.invalid("Invalid object because is null."));
    }

    private static <T> Validation<String, T> buildValidationError(
        T object,
        Set<ConstraintViolation<T>> constraintViolations
    ) {
        if (constraintViolations.isEmpty()) {
            return Validation.valid(object);
        }
        final var errorMessages = constraintViolations.stream()
            .map(ConstraintViolation::getMessage)
            .reduce("%s, %s"::formatted)
            .orElse("Unknown validation error");
        return Validation.invalid(errorMessages);
    }
}
