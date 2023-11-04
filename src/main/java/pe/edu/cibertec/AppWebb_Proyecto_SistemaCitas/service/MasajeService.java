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
            if(masaje.getId_masaje()>0){
                objMasaje.setId_masaje(masaje.getId_masaje());
            }
            objMasaje.setPrecio_masaje((masaje.getPrecio_masaje()));
            objMasaje.setTiempo_masaje((masaje.getTiempo_masaje()));


            DescMasaje descMasaje = new DescMasaje();
            descMasaje.setId_desc_masaje(masaje.getId_desc_masaje());
            objMasaje.setDescmasaje(descMasaje);

            masajeRepository.save(objMasaje);
        }catch (Exception ex){
            mensaje = "Masaje no registro";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}