package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescMasaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Masaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.MasajeRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.MasajeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class MasajeService {

    private MasajeRepository masajeRepository;

    public List<Masaje> listarMasaje() {return masajeRepository.findAll();}

    public ResultadoResponse guaradarMasaje(MasajeRequest masaje){
        String mensaje = "Masaje registrado Correctamente";
        Boolean respuesta = true;
        try{
            Masaje objMasaje = new Masaje();
            if(masaje.getIdmasaje()>0){
                objMasaje.setIdmasaje(masaje.getIdmasaje());
            }
            objMasaje.setPreciomasaje((masaje.getPreciomasaje()));
            objMasaje.setTiempomasaje((masaje.getTiempomasaje()));
            objMasaje.setDescripcion((masaje.getDescripcion()));

            DescMasaje descMasaje = new DescMasaje();
            descMasaje.setIddescmasaje(masaje.getIddescmasaje());
            objMasaje.setDescmasaje(descMasaje);

            masajeRepository.save(objMasaje);
        }catch (Exception ex){
            mensaje = "Masaje no registro";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}