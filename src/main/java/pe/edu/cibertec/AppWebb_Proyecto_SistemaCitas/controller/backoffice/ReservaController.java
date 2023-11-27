package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/reserva")
public class ReservaController {
    @GetMapping("/reserva")
    public String reserva() {
        return "backoffice/Reserva/frmMantReserva";
    }
}