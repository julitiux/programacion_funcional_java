package com.circulosiete.curso.funcional.clase12.web;

import com.circulosiete.curso.funcional.clase12.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody PersonCommand personCommand) {
        return ResponseFactory.from(
                personService.save(personCommand)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseFactory.from(
                personService.findById(id)
        );
    }
}
