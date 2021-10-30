package bethacode.clinimais.resource;

import bethacode.clinimais.model.Paciente;
import bethacode.clinimais.repository.PacienteRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

//    @GetMapping
//    public List<Paciente> getPaciente() {
//        return repository.findAll();
//    }

//Abaixo é a consulta na entidade dos paciente 'original'
//    @GetMapping
//    public List<Paciente> getPaciente(@QuerydslPredicate(root = Paciente.class) Predicate predicate) {
//        List<Paciente> result = new ArrayList<>();
//        Iterable<Paciente> all = repository.findAll(predicate);
//        all.forEach(f -> result.add(f));
//        return (result);
//    }

    //Abaixo é a consulta na entidade dos PacienteDTO
    @GetMapping
    public List<PacienteDTO> getPaciente(@QuerydslPredicate(root = Paciente.class) Predicate predicate) {
        List<PacienteDTO> result = new ArrayList<>();
        Iterable<Paciente> all = repository.findAll(predicate);
        all.forEach(f -> result.add(PacienteDTO.toDTO(f)));
        return (result);
    }

    @PostMapping
    public Paciente create(@Valid @RequestBody Paciente paciente){
        return repository.save(paciente);
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
