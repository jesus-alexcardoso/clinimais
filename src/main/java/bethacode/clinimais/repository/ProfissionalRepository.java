package bethacode.clinimais.repository;

import bethacode.clinimais.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>, QuerydslPredicateExecutor<Profissional> {
}