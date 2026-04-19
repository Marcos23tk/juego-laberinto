package com.Fotocopiadoras.Fotocopiadoras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Fotocopiadoras.Fotocopiadoras.Service.SedeService;

@Controller
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping("/sedes")
    public String listarSedes(Model model) {
        model.addAttribute("sedes", sedeService.listar());
        return "sedes";
    }
}