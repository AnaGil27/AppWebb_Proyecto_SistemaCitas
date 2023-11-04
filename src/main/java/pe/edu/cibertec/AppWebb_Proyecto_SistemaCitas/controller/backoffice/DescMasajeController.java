package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescMasaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.DescMasajeService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/descmasaje")
public class DescMasajeController {

    private DescMasajeService descMasajeService;

    @GetMapping("/listar")
    @ResponseBody
    public List<DescMasaje> listarDescMasaje(){return descMasajeService.listarDescMasaje();}
}