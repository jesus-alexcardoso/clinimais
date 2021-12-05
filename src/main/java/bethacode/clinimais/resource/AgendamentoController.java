package bethacode.clinimais.resource;

import bethacode.clinimais.enterprise.ValidationException;
import bethacode.clinimais.model.Agendamento;
import bethacode.clinimais.repository.AgendamentoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController extends AbstractResource{

    @Autowired
    private AgendamentoRepository repository;

    @GetMapping
    public List<AgendamentoDTO> getAgendamento(@QuerydslPredicate(root = Agendamento.class) Predicate predicate) {
        List<AgendamentoDTO> result = new ArrayList<>();
        Iterable<Agendamento> all = repository.findAll(predicate);
        all.forEach(f -> result.add(AgendamentoDTO.toDTO(f)));
        return (result);
    }

    @GetMapping("/{id}")
    public AgendamentoDTO getAgendamentoId(@PathVariable(value = "id") Long id) throws EntityNotFoundException {

        Agendamento agendamentoFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com ID :: " + id));

        return AgendamentoDTO.toDTO(agendamentoFind);
    }

    @PostMapping
    public Agendamento create(@Valid @RequestBody Agendamento agendamento) {

        return repository.save(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento update(@PathVariable(value = "id") Long id,
                           @RequestBody Agendamento agendamento) throws EntityNotFoundException {
        Agendamento agendamentoFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrado com ID: " + id));

        agendamentoFind.setBackgroundColor(agendamento.getBackgroundColor());
        agendamentoFind.setTitle(agendamento.getTitle());
        agendamentoFind.setTitulo(agendamento.getTitulo());
        agendamentoFind.setEnd(agendamento.getEnd());
        agendamentoFind.setStart(agendamento.getStart());
        agendamentoFind.setPaciente(agendamento.getPaciente());
        agendamentoFind.setProfissional(agendamento.getProfissional());
        agendamentoFind.setProcedimento(agendamento.getProcedimento());
        agendamentoFind.setObservacao(agendamento.getObservacao());
        agendamentoFind.setSituacao(agendamento.getSituacao());

        return repository.save(agendamentoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        Agendamento agendamentoFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com ID :: " + id));

        repository.delete(agendamentoFind);

        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;

    }


}
