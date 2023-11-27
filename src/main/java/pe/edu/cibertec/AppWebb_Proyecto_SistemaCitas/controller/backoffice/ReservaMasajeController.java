package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.ReservaMasaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaMasajeRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.ReservaMasajeService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reservamasaje")
public class ReservaMasajeController {
    private ReservaMasajeService reservaMasajeService;

    @GetMapping("/reservamasaje")
    public String reservamasaje() {
        return "backoffice/Reserva/frmMantReservaMasaje";
    }
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaReservaMasaje",
                reservaMasajeService.listarReservaMasaje());
        return "backoffice/reserva/frmMantReservaMasaje";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<ReservaMasaje> listarReservaMasaje(){
        return reservaMasajeService.listarReservaMasaje();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarReservaMasaje(
            @RequestBody ReservaMasajeRequest reservaRequest
    ){
        return reservaMasajeService.guardarReservaMasaje(reservaRequest);
    }
}
