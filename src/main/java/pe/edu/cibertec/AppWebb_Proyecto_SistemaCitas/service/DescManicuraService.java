package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescManicura;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.DescManicuraRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DescManicuraService {
    private DescManicuraRepository descManicuraRepository;

    public List<DescManicura> listarDescManicura(){
        return descManicuraRepository.findAll();
    }
}
