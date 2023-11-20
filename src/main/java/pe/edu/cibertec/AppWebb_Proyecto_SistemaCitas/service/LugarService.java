package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.*;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.LugarRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.LugarRepository;


import java.util.List;
@AllArgsConstructor
@Service
public class LugarService {
    private LugarRepository lugarRepository;

    public List<Lugar> listarLugar(){
        return lugarRepository.findAll();
    }
    public ResultadoResponse guardarLugar(LugarRequest lugar){
        String mensaje = "Lugar Registrado Correctamente";
        Boolean respuesta = true;
        try{
            Lugar objLugar = new Lugar();
            if(lugar.getIdLugar()>0){
                objLugar.setIdLugar(lugar.getIdLugar());
            }
            objLugar.setCiudad(lugar.getCiudad());
            objLugar.setDistrito(lugar.getDistrito());

            lugarRepository.save(objLugar);

        }catch(Exception ex){
            mensaje = "Lugar no Registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}

