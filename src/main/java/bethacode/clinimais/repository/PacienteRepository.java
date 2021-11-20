package bethacode.clinimais.repository;

import bethacode.clinimais.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>, QuerydslPredicateExecutor<Paciente> {
    List<Paciente> findByCpf(String cpf);
}
