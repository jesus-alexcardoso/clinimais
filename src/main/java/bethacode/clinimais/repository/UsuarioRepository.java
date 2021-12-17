package bethacode.clinimais.repository;

import bethacode.clinimais.model.Paciente;
import bethacode.clinimais.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>, QuerydslPredicateExecutor<Usuario> {
    List<Usuario> findByUsuario(String usuario);
}
