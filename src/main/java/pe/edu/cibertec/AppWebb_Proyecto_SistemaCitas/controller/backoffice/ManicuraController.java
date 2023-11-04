package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Manicura;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ManicuraRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.ManicuraService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/manicura")
public class ManicuraController {
    private ManicuraService manicuraService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listarManicura",
                manicuraService.listarManicura());
        return "backoffice/manicura/frmMantManicura";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Manicura> listarManicura(){
        return manicuraService.listarManicura();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarManicura(
            @RequestBody ManicuraRequest manicuraRequest
    ){
        return manicuraService.guardarManicura(manicuraRequest);
    }
}
