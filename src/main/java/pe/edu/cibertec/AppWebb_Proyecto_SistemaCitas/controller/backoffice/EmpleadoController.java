package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Lugar;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.EmpleadoRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.EmpleadoService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/empleado")
public class EmpleadoController {
    private EmpleadoService empleadoService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listarEmpleado",
                empleadoService.listarEmpleado());
        return "backoffice/Empleado/frmMantEmpleado";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Lugar> listarEmpleado(){
        return empleadoService.listarEmpleado();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarEspecialista(
            @RequestBody EmpleadoRequest empleadoRequest
    ){
        return empleadoService.guardarEmpleado(empleadoRequest);
    }
}

