package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Empleado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.EmpleadoRequest;

import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.EmpleadoRepository;


import java.util.List;

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
                objEmpleado.setIdEmpleado(empleado.getIdEmpleado());
            }
            objEmpleado.setNomEmpleado(empleado.getNomEmpleado());
            objEmpleado.setApeEmpleado(empleado.getApeEmpleado());
            objEmpleado.setCelularEmpleado(empleado.getCelularEmpleado());

            empleadoRepository.save(objEmpleado);

        }catch(Exception ex){
            mensaje = "Empleado no Registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}


