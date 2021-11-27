package bethacode.clinimais.repository;

import bethacode.clinimais.model.Paciente;
import bethacode.clinimais.model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long>, QuerydslPredicateExecutor<Procedimento> {
    List<Procedimento> findByDescricao(String descricao);
}
