package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.frontoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @GetMapping("/NataliaH")
    public String nataliaH() {
        return "frontoffice/emp/NataliaH";
    }

    @GetMapping("/RaulG")
    public String raulG() {
        return "frontoffice/emp/RaulG";
    }
    @GetMapping("/AndreP")
    public String andrePulG() {
        return "frontoffice/emp/AndreP";
    }
    @GetMapping("/Isabel")
    public String isabel() {
        return "frontoffice/emp/Isabel";
    }
    @GetMapping("/Hector")
    public String hector() {
        return "frontoffice/emp/Hector";
    }
}
