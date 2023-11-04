package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Masaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.MasajeRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.MasajeService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/masaje")
public class MasajeController {

    private MasajeService masajeService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listarMasaje",
                masajeService.listarMasaje());
        return "backoffice/masaje/frmMantMasaje";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Masaje> listarMasaje(){return masajeService.listarMasaje();}

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarMasaje(
            @RequestBody MasajeRequest masajeRequest
    ){
        return masajeService.guaradarMasaje(masajeRequest);
    }
}