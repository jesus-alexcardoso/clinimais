package bethacode.clinimais.repository;

import bethacode.clinimais.model.Agendamento;
import bethacode.clinimais.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>, QuerydslPredicateExecutor<Agendamento> {
}