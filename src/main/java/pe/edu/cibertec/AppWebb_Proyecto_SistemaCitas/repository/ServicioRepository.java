package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Masaje;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}
