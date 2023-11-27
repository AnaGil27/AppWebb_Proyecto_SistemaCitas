package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaMaquillajeRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.ReservaMaquillajeRepository;



import java.util.List;
@AllArgsConstructor
@Service
public class ReservaMaquillajeService {
    private ReservaMaquillajeRepository reservaMaquillajeRepository;

    public List<ReservaMaquillaje> listarReservaMaquillaje(){
        return reservaMaquillajeRepository.findAll();
    }
    public ResultadoResponse guardarReservaMaquillaje(ReservaMaquillajeRequest reservaMaquillaje) {
        String mensaje = "Reserva registrada correctamente";
        Boolean respuesta = true;
        try {
            ReservaMaquillaje objReservaMaquillaje = new ReservaMaquillaje();
            if (reservaMaquillaje.getId_reserva_maquillaje() > 0) {
                objReservaMaquillaje.setId_reserva_maquillaje(reservaMaquillaje.getId_reserva_maquillaje());
            }

            Usuario usuario = new Usuario();
            usuario.setIdusuario(reservaMaquillaje.getIdusuario());
            objReservaMaquillaje.setUsuario(usuario);

            Lugar lugar = new Lugar();
            lugar.setId_lugar(reservaMaquillaje.getId_lugar());
            objReservaMaquillaje.setLugar(lugar);

            Empleado empleado = new Empleado();
            empleado.setId_empleado(reservaMaquillaje.getId_empleado());
            objReservaMaquillaje.setEmpleado(empleado);

            Maquillaje maquillaje = new Maquillaje();
            maquillaje.setId_maquillaje(reservaMaquillaje.getId_maquillaje());
            objReservaMaquillaje.setMaquillaje(maquillaje);

            objReservaMaquillaje.setFechaP(reservaMaquillaje.getFechaP());

            reservaMaquillajeRepository.save(objReservaMaquillaje);
        }catch (Exception ex){
            mensaje = "Reserva no registrada";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}

