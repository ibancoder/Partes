package com.teletecnics.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.teletecnics.backend.model.ParteTrabajo;
import com.teletecnics.backend.repository.ParteTrabajoRepository;

@CrossOrigin (origins = "http://localhost:5173")
@RestController 
@RequestMapping ("/api/partes")
public class ParteTrabajoController {

    private final ParteTrabajoRepository repository;

    public ParteTrabajoController(ParteTrabajoRepository repository){
        this.repository = repository;
    }

    @GetMapping 
    public List<ParteTrabajo> listar(){
        return repository.findAll();
    }

   @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParteTrabajo crear(@RequestBody ParteTrabajo parte) {
        parte.setId(null);

        if (parte.getCliente() == null
                || parte.getCliente().isBlank()
                || parte.getDescripcion() == null
                || parte.getDescripcion().isBlank()
                || parte.getFecha() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Cliente, descripción y fecha son obligatorios"
            );
        }

        parte.setEstado("PENDIENTE");

        return repository.save(parte);
    }
}
