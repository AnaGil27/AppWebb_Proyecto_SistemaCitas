package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.ReservaRepository;


import java.util.List;
@AllArgsConstructor
@Service
public class ReservaService {

    private ReservaRepository reservaRepository;

    public List<Reserva> listarReserva(){return reservaRepository.findAll();}
    public ResultadoResponse guardarReserva(ReservaRequest reserva) {
        String mensaje = "Reserva registrada correctamente";
        Boolean respuesta = true;
        try {
            Reserva objReserva = new Reserva();
            if (reserva.getId_reserva() > 0) {
                objReserva.setId_reserva(reserva.getId_reserva());
            }

            Usuario usuario = new Usuario();
            usuario.setIdusuario(reserva.getIdusuario());
            objReserva.setUsuario(usuario);

            Servicio servicio = new Servicio();
            servicio.setIdServicios(servicio.getIdServicios());
            objReserva.setServicio(servicio);


            Empleado empleado = new Empleado();
            empleado.setId_empleado(reserva.getId_empleado());
            objReserva.setEmpleado(empleado);

            Lugar lugar = new Lugar();
            lugar.setId_lugar(reserva.getId_lugar());
            objReserva.setLugar(lugar);

            objReserva.setFechaReserva(reserva.getFecha_reserva());

            reservaRepository.save(objReserva);
        }catch (Exception ex){
            mensaje = "reserva no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
