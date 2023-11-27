package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.controller.frontoffice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Usuario;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.EmailService;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service.UsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/login")
    public String login(){
        return "frontoffice/auth/frmLogin";
    }

    @GetMapping("/registrar")
    public String registrar(){
        return "frontoffice/auth/frmRegistroUsuario";
    }

    @GetMapping("/login-success")
    public String loginSucces(HttpServletRequest request){
        System.out.println("Ingresó al método loginSucces");
        UserDetails usuario = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal(); //Linea 45
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario.getUsername());
        return "frontoffice/auth/home";

    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        System.out.println("Se guardó el usuarioooooo");
        usuarioService.saveUser(usuario);
        emailService.enviarCorreoConfirmacion(usuario);
        return "frontoffice/auth/frmLogin";
    }

}
