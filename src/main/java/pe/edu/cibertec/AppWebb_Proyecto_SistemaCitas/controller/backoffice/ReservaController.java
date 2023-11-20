package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Peinado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Reserva;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.PeinadoRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.ReservaService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reserva")
public class ReservaController {

    private ReservaService reservaService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaReserva",
                reservaService.listarReserva());
        return "backoffice/reserva/frmMantReserva";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<Reserva> listarReserva(){
        return reservaService.listarReserva();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarReserva(
            @RequestBody ReservaRequest reservaRequest
    ){
        return reservaService.guardarReserva(reservaRequest);
    }
}
