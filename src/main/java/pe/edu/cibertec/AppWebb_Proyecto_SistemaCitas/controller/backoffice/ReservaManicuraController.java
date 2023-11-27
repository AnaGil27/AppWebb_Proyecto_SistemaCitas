package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.ReservaManicura;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaManicuraRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.ReservaManicuraService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reservamanicura")
public class ReservaManicuraController {
    private ReservaManicuraService reservaManicuraService;
    @GetMapping("/reservamanicura")
    public String reservamanicura() {
        return "backoffice/Reserva/frmMantReservaManicura";
    }
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaReservaManicura",
                reservaManicuraService.listarReservaManicura());
        return "backoffice/Reserva/frmMantReservaManicura";
    }
    @GetMapping("/listar")
    @ResponseBody
    public List<ReservaManicura> listarReservaManicura(){
        return reservaManicuraService.listarReservaManicura();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarReservaManicura(
            @RequestBody ReservaManicuraRequest reservaManicuraRequest
    ){
        return reservaManicuraService.guardarReservaManicura(reservaManicuraRequest);
    }
}