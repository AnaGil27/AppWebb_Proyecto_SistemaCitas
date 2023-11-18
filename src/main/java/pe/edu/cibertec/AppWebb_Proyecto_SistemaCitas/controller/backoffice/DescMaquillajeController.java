package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescMaquillaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.DescMaquillajeService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/descmaquillaje")
public class DescMaquillajeController {
    private DescMaquillajeService descMaquillajeService;

    @GetMapping("/listar")
    @ResponseBody
    public List<DescMaquillaje> listarDescMaquillaje(){
        return descMaquillajeService.listarDescMaquillaje();
    }
}
