package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.ReservaPeinado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaPeinadoRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.ReservaPeinadoService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reservaPeinado")
public class ReservaPeinadoController {

    private ReservaPeinadoService reservaPeinadoService;

    @GetMapping("/reservaPeinado")
    public String reservaPeinado() {
        return "backoffice/Reserva/frmMantReservaPeinado";
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaReservaPeinado",
                reservaPeinadoService.listarReservaPeinado());
        return "backoffice/reserva/frmMantReservaPeinado";
    }
    @GetMapping("/listarReservaPeinado")
    @ResponseBody
    public List<ReservaPeinado> listarReservaPeinado(){
        return reservaPeinadoService.listarReservaPeinado();
    }

    @PostMapping("/guardarReservaPeinado")
    @ResponseBody
    public ResultadoResponse guardarReservaPeinado(
            @RequestBody ReservaPeinadoRequest reservaRequest
    ){
        return reservaPeinadoService.guardarReservaPeinado(reservaRequest);
    }
}
