package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Peinado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.PeinadoRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.PeinadoService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/peinado")
public class PeinadoController {

    private PeinadoService peinadoService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaPeinado",
                peinadoService.listarPeinado());
        return "backoffice/peinado/frmMantPeinado";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Peinado> listarPeinado(){
        return peinadoService.listarPeinado();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarPeinado(
            @RequestBody PeinadoRequest peinadoRequest
    ){
        return peinadoService.guardarPeinado(peinadoRequest);
    }
}
