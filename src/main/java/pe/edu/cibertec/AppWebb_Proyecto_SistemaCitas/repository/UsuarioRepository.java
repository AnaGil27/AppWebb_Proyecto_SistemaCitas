package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    /*Usuario findByEmail(String email);*/
    Usuario findByNomusuario(String nomusuario);
    Usuario findByPassword(String password);

}