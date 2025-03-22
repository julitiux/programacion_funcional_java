package com.circulosiete.curso.funcional.clase11;

import com.circulosiete.curso.funcional.clase11.errorhandling.Failure;
import io.vavr.Tuple;
import io.vavr.control.Option;
import io.vavr.control.Validation;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;

public class Lab02 {
    private static final ValidatorFactory factory = jakarta.validation.Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> Validation<Failure<String, ConstraintViolation<T>>, T> validate(T object) {
        return Option.of(object)
            .map(o -> Tuple.of(o, validator.validate(o)))
            .map(data -> buildValidationErrorFailure(data._1, data._2))
            .getOrElse(() -> getInvalid("Invalid object because is null."));
    }

    @SuppressWarnings("unchecked")
    private static <T> Validation<Failure<String, ConstraintViolation<T>>, T> getInvalid(String message) {
        return Validation.invalid(
            (Failure<String, ConstraintViolation<T>>)
                Failure.of(message)
        );
    }

    @SuppressWarnings("unchecked")
    private static <T> Failure<ConstraintViolation<T>, Void> toFailure(ConstraintViolation<T> constraintViolation) {
        return (Failure<ConstraintViolation<T>, Void>)
            Failure.of(constraintViolation.getMessage(), constraintViolation);
    }

    private static <T> Validation<Failure<String, ConstraintViolation<T>>, T> buildValidationErrorFailure(
        T object,
        Set<ConstraintViolation<T>> constraintViolations
    ) {
        if (constraintViolations.isEmpty()) {
            return Validation.valid(object);
        }
        final var violations = constraintViolations.stream()
            .map(Lab02::toFailure)
            .toList();

        return Validation.invalid(
            Failure.of(
                "The provided object contains violations.",
                "",
                violations
            )
        );
    }
}
