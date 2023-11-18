package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Maquillaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.MaquillajeRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.MaquillajeService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/maquillaje")
public class MaquillajeController {
    private MaquillajeService maquillajeService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listaMaquillaje",
                maquillajeService.listarMaquillaje());
        return "backoffice/maquillaje/frmMantMaquillaje";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Maquillaje> listarMaquillaje(){
        return maquillajeService.listarMaquillaje();
    }
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarMaquillaje(
            @RequestBody MaquillajeRequest maquillajeRequest
    ){
        return maquillajeService.guardarMaquillaje(maquillajeRequest);
    }

}
