package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Lugar;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.LugarRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ManicuraRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.LugarService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/lugar")
public class LugarController {
    private LugarService lugarService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listarLugar",
                lugarService.listarLugar());
        return "backoffice/Lugar/frmMantLugar";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Lugar> listarLugar(){
        return lugarService.listarLugar();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarLugar(
            @RequestBody LugarRequest lugarRequest
    ){
        return lugarService.guardarLugar(lugarRequest);
    }
}
