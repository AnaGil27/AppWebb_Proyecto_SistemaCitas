package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ReservaManicuraRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.ReservaManicuraRepository;


import java.util.List;
@AllArgsConstructor
@Service
public class ReservaManicuraService {

    private ReservaManicuraRepository reservaManicuraRepository;

    public List<ReservaManicura> listarReservaManicura(){
        return reservaManicuraRepository.findAll();
    }
    public ResultadoResponse guardarReservaManicura(ReservaManicuraRequest reservaManicura) {
        String mensaje = "Reserva registrada correctamente";
        Boolean respuesta = true;
        try {
            ReservaManicura objReservaManicura = new ReservaManicura();
            if (reservaManicura.getId_reserva_manicura() > 0) {
                objReservaManicura.setId_reserva_manicura(reservaManicura.getId_reserva_manicura());
            }

            Usuario usuario = new Usuario();
            usuario.setIdusuario(reservaManicura.getIdusuario());
            objReservaManicura.setUsuario(usuario);

            Lugar lugar = new Lugar();
            lugar.setId_lugar(reservaManicura.getId_lugar());
            objReservaManicura.setLugar(lugar);

            Empleado empleado = new Empleado();
            empleado.setId_empleado(reservaManicura.getId_empleado());
            objReservaManicura.setEmpleado(empleado);

            Manicura manicura = new Manicura();
            manicura.setIdmanicura(reservaManicura.getIdmanicura());
            manicura.setPreciomanicura(manicura.getPreciomanicura());
            objReservaManicura.setManicura(manicura);

            objReservaManicura.setFechaM(reservaManicura.getFechaM());

            reservaManicuraRepository.save(objReservaManicura);
        }catch (Exception ex){
            mensaje = "Reserva registrada correctamente , muchas gracias mi estimado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}