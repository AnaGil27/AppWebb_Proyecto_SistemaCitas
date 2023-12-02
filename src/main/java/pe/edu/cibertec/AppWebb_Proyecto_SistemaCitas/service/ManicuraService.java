package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescManicura;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Manicura;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.request.ManicuraRequest;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.response.ResultadoResponse;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.ManicuraRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ManicuraService {
    private ManicuraRepository manicuraRepository;

    public List<Manicura> listarManicura(){
        return manicuraRepository.findAll();
    }
    public ResultadoResponse guardarManicura(ManicuraRequest manicura){
        String mensaje = "Manicura Registrado Correctamente";
        Boolean respuesta = true;
        try{
            Manicura objManicura = new Manicura();
            if(manicura.getIdmanicura()>0){
                objManicura.setIdmanicura(manicura.getIdmanicura());
            }
            objManicura.setPreciomanicura(manicura.getPreciomanicura());
            objManicura.setTiempomanicura(manicura.getTiempomanicura());
            objManicura.setDescripcion(manicura.getDescripcion());

            DescManicura descManicura = new DescManicura();
            descManicura.setIddescmanicura(manicura.getIddescmanicura());
            objManicura.setDescmanicura(descManicura);

            manicuraRepository.save(objManicura);

        }catch(Exception ex){
            mensaje = "Manicura no Registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
