package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescMaquillaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.DescMaquillajeRepository;
import java.util.List;

@AllArgsConstructor
@Service
public class DescMaquillajeService {
    private DescMaquillajeRepository descMaquillajeRepository;

    public List<DescMaquillaje> listarDescMaquillaje(){
        return descMaquillajeRepository.findAll();
    }
}
