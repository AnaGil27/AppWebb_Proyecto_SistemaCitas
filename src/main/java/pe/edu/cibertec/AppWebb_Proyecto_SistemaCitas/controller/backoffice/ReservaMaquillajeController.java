package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.ReservaMaquillaje;

import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaMaquillajeRequest;

import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.ReservaMaquillajeService;


import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reservamaquillaje")
public class ReservaMaquillajeController {
    private ReservaMaquillajeService reservaMaquillajeService;

    @GetMapping("/reservamaquillaje")
    public String reservamaquillaje() {
        return "backoffice/Reserva/frmMantReservaMaquillaje";
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaReservaMaquillaje",
                reservaMaquillajeService.listarReservaMaquillaje());
        return "backoffice/Reserva/frmMantReservaMaquillaje";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<ReservaMaquillaje> listarReservaMaquillaje(){
        return reservaMaquillajeService.listarReservaMaquillaje();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarReservaMaquillaje(
            @RequestBody ReservaMaquillajeRequest reservaMaquillajeRequest
    ){
        return reservaMaquillajeService.guardarReservaMaquillaje(reservaMaquillajeRequest);
    }
}
