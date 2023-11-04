package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescPeinado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.PeinadoRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.DescPeinadoService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/descpeinado")
public class DescPeinadoController {

    private DescPeinadoService descPeinadoService;

    @GetMapping("/listar")
    @ResponseBody
    public List<DescPeinado> listarDescPeinado(){
        return descPeinadoService.listarDescPeinado();
    }
}