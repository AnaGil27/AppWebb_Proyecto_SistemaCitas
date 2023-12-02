package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaMasajeRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.ReservaMasajeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ReservaMasajeService {

    private ReservaMasajeRepository reservaMasajeRepository;

    public List<ReservaMasaje> listarReservaMasaje(){
        return reservaMasajeRepository.findAll();
    }
    public ResultadoResponse guardarReservaMasaje(ReservaMasajeRequest reservaMasaje) {
        String mensaje = "Reserva registrada correctamente";
        Boolean respuesta = true;
        try {
            ReservaMasaje objReservaMasaje = new ReservaMasaje();
            if (reservaMasaje.getId_reserva_masaje() > 0) {
                objReservaMasaje.setId_reserva_masaje(reservaMasaje.getId_reserva_masaje());
            }

            Usuario usuario = new Usuario();
            usuario.setIdusuario(reservaMasaje.getIdusuario());
            objReservaMasaje.setUsuario(usuario);

            Lugar lugar = new Lugar();
            lugar.setId_lugar(reservaMasaje.getId_lugar());
            objReservaMasaje.setLugar(lugar);

            Empleado empleado = new Empleado();
            empleado.setId_empleado(reservaMasaje.getId_empleado());
            objReservaMasaje.setEmpleado(empleado);

            Masaje masaje = new Masaje();
            masaje.setIdmasaje(reservaMasaje.getIdmasaje());
            objReservaMasaje.setMasaje(masaje);

            objReservaMasaje.setFechaJ(reservaMasaje.getFechaJ());

            reservaMasajeRepository.save(objReservaMasaje);
        }catch (Exception ex){
            mensaje = "Reserva no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
