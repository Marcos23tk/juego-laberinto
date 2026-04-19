package com.Fotocopiadoras.Fotocopiadoras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Fotocopiadoras.Fotocopiadoras.Service.MarcaService;

@Controller
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/marcas")
    public String listarMarcas(Model model) {
        model.addAttribute("marcas", marcaService.listar());
        return "marcas";
    }
}