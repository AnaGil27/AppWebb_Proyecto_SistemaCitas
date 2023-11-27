package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Reserva;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Servicio;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ServicioRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.ServicioService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/servicio")
public class ServicioController {
    private ServicioService servicioService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaServicio",
                servicioService.listarServicio());
        return "backoffice/servicio/frmMantServicio";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Servicio> listarServicio(){
        return servicioService.listarServicio();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarServicio(
            @RequestBody ServicioRequest servicioRequest
    ){
        return servicioService.guardarServicio(servicioRequest);
    }

}
