package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescPeinado;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.DescPeinadoRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DescPeinadoService {

    private DescPeinadoRepository descPeinadoRepository;

    public List<DescPeinado> listarDescPeinado(){
        return descPeinadoRepository.findAll();
    }
}