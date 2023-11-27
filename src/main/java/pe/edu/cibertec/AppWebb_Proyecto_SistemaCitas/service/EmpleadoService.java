package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Empleado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Lugar;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.EmpleadoRequest;

import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.EmpleadoRepository;


import java.util.List;

@AllArgsConstructor
@Service
public class EmpleadoService {
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarEmpleado(){
        return empleadoRepository.findAll();
    }
    public ResultadoResponse guardarEmpleado(EmpleadoRequest empleado){
        String mensaje = "Empleado Registrado Correctamente";
        Boolean respuesta = true;
        try{
            Empleado objEmpleado = new Empleado();
            if(empleado.getIdEmpleado()>0){
                objEmpleado.setId_empleado(empleado.getIdEmpleado());
            }
            objEmpleado.setNom_empleado(empleado.getNom_empleado());
            objEmpleado.setApe_empleado(empleado.getApe_empleado());
            objEmpleado.setCelular_empleado(empleado.getCelular_empleado());

            Lugar lugar = new Lugar();
            lugar.setId_lugar(empleado.getId_lugar());
            objEmpleado.setLugar(lugar);

            empleadoRepository.save(objEmpleado);

        }catch(Exception ex){
            mensaje = "Empleado no Registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}


