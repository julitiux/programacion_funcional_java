package com.circulosiete.curso.funcional.clase12.web;

import com.circulosiete.curso.funcional.errorhandling.Failure;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseFactory {
    public static <T> ResponseEntity<?> from(Either<Failure<String, String>, T> response) {
        return response.fold(
                ResponseFactory::handleFailure,
                ResponseEntity::ok
        );
    }

    private static ResponseEntity<?> handleFailure(Failure<String, String> failure) {
        var errorResponse = new ErrorResponse<>(
                failure.message(),
                failure.errorCode()
                        .orElse(""),
                failure.details().orElse(List.of())
        );
        var errorCode = failure
                .errorCode()
                .orElse("unknown");
        System.out.println(failure.reason());
        return switch (errorCode) {
            case "validation_error" -> ResponseEntity
                    .unprocessableEntity()
                    .body(errorResponse);
            case "illegal_argument_exception" -> ResponseEntity
                    .badRequest()
                    .body(errorResponse);
            case "not_found" -> ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorResponse);
            default -> ResponseEntity.internalServerError().body(errorResponse);
        };
    }
}
