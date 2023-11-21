package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.frontoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {
    @GetMapping("/EspecialidadManicura")
    public String especialidad() {
        return "frontoffice/especialidad/EspecialidadManicura";
    }
    @GetMapping("/EspecialidadPeinado")
    public String SedeSanIsidro() {
        return "frontoffice/especialidad/EspecialidadPeinado";
    }
    @GetMapping("/EspecialidadMaquillaje")
    public String especialidadMaquillaje() {
        return "frontoffice/especialidad/EspecialidadMaquillaje";
    }
    @GetMapping("/EspecialidadMasaje")
    public String especialidadMasaje() {
        return "frontoffice/especialidad/EspecialidadMasaje";
    }
}
