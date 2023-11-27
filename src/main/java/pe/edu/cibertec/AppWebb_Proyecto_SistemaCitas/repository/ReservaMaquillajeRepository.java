package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.ReservaMaquillaje;

@Repository
public interface ReservaMaquillajeRepository extends JpaRepository<ReservaMaquillaje,Integer> {
}
