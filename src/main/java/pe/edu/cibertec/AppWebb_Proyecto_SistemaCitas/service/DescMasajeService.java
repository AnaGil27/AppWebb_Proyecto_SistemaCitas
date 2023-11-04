package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.DescMasaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository.DescMasajeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DescMasajeService {
    private DescMasajeRepository descMasajeRepository;

    public List<DescMasaje> listarDescMasaje(){return descMasajeRepository.findAll();}
}