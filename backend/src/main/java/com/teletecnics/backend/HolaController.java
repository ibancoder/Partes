package com.teletecnics.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "http://localhost:5173")
@RestController 
public class HolaController {
    
    @GetMapping("/api/hola")
    public String hola(){
        return "El backend de partes de trabajo funciona.";
    }
}
