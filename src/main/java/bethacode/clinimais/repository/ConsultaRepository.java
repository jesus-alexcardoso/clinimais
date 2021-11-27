package bethacode.clinimais.repository;

import bethacode.clinimais.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>, QuerydslPredicateExecutor<Consulta> {
}
