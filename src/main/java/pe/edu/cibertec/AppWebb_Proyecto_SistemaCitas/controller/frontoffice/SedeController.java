package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.frontoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sede")
public class SedeController {

    @GetMapping("/SedeMiraflores")
    public String sedeMiraflores() {
        return "frontoffice/sede/SedeMiraflores";
    }
    @GetMapping("/SedeSanIsidro")
    public String sedeSanIsidro() {
        return "frontoffice/sede/SedeSanIsidro";
    }
    @GetMapping("/SedeSantiagodeSurco")
    public String sedeSantiagodeSurco() {
        return "frontoffice/sede/SedeSantiagodeSurco";
    }
    @GetMapping("/SedeBellavista")
    public String sedeBellavista() {
        return "frontoffice/sede/SedeBellavista";
    }
    @GetMapping("/SedeSanBorja")
    public String sedeSanBorja() {
        return "frontoffice/sede/SedeSanBorja";
    }
    @GetMapping("/SedeJesusMaria")
    public String sedeJesusMaria() {
        return "frontoffice/sede/SedeJesusMaria";
    }
    @GetMapping("/SedeMagdalenadelMar")
    public String sedeMagdalenadelMar() {
        return "frontoffice/sede/SedeMagdalenadelMar";
    }
    @GetMapping("/SedePuebloLibre")
    public String sedePuebloLibre() {
        return "frontoffice/sede/SedePuebloLibre";
    }
    @GetMapping("/SedeSanMiguel")
    public String sedeSanMiguel() {
        return "frontoffice/sede/SedeSanMiguel";
    }


}