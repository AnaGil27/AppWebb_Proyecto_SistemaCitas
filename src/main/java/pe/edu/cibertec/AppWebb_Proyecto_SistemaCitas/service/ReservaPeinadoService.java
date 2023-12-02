package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaPeinadoRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.ReservaPeinadoRepository;


import java.util.List;
@AllArgsConstructor
@Service
public class ReservaPeinadoService {

    private ReservaPeinadoRepository reservaPeinadoRepository;

    public List<ReservaPeinado> listarReservaPeinado(){
        return reservaPeinadoRepository.findAll();
    }
    public ResultadoResponse guardarReservaPeinado(ReservaPeinadoRequest reservaPeinado) {
        String mensaje = "Reserva registrada correctamente";
        Boolean respuesta = true;
        try {
            ReservaPeinado objReservaPeinado = new ReservaPeinado();
            if (reservaPeinado.getId_reservaPeinado() > 0) {
                objReservaPeinado.setId_reservaPeinado(reservaPeinado.getId_reservaPeinado());
            }

            Usuario usuario = new Usuario();
            usuario.setIdusuario(reservaPeinado.getIdusuario());
            objReservaPeinado.setUsuario(usuario);

            Lugar lugar = new Lugar();
            lugar.setId_lugar(reservaPeinado.getId_lugar());
            objReservaPeinado.setLugar(lugar);

            Empleado empleado = new Empleado();
            empleado.setId_empleado(reservaPeinado.getId_empleado());
            objReservaPeinado.setEmpleado(empleado);

            Peinado peinado = new Peinado();
            peinado.setIdpeinado(reservaPeinado.getIdpeinado());
            objReservaPeinado.setPeinado(peinado);

            objReservaPeinado.setFechaP(reservaPeinado.getFechaP());

            reservaPeinadoRepository.save(objReservaPeinado);
        }catch (Exception ex){
            mensaje = "Reserva no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
