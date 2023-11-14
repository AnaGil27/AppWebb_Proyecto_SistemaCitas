package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Usuario;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarCorreoConfirmacion(Usuario usuario) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(usuario.getEmail());
        mensaje.setSubject("Confirmación de Creación de Cuenta");
        mensaje.setText("¡Tu cuenta ha sido creada con éxito!");

        javaMailSender.send(mensaje);
    }


}
