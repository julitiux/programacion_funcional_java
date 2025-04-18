package com.circulosiete.curso.funcional.clase12.service;

import com.circulosiete.curso.funcional.clase12.mapper.PersonMapper;
import com.circulosiete.curso.funcional.clase12.persistence.PersonRepository;
import com.circulosiete.curso.funcional.clase12.validation.Validator;
import com.circulosiete.curso.funcional.clase12.web.PersonCommand;
import com.circulosiete.curso.funcional.clase12.web.SavedPerson;
import com.circulosiete.curso.funcional.errorhandling.Failure;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Either<Failure<String, String>, SavedPerson> save(PersonCommand personCommand) {
        return Validator.validateObject(personCommand)
                .map(PersonMapper.INSTANCE::commandToEntity)
                .flatMap(personRepository::persist)
                .map(SavedPerson::from);
    }

    public Either<Failure<String, String>, SavedPerson> findById(Long id) {
        return Option.ofOptional(personRepository.findById(id))
                .toEither(() -> new Failure<String, String>(
                        "Usuario no encontrado",
                        Optional.of("User not found with id: %d".formatted(id)),
                        Optional.of("not_found"),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.of("")
                ))
                .map(SavedPerson::from);
    }
}
