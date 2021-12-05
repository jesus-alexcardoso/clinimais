package bethacode.clinimais.resource;

import bethacode.clinimais.enterprise.ValidationException;
import bethacode.clinimais.model.Paciente;
import bethacode.clinimais.model.QPaciente;
import bethacode.clinimais.repository.PacienteRepository;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("api/pacientes")
@Api(value="Rest Pacientes")
@CrossOrigin(origins="*")
public class PacienteController extends AbstractResource{

    @Autowired
    private PacienteRepository repository;

//    @GetMapping
//    public List<Paciente> getPaciente() {
//        return repository.findAll();
//    }

//    //Abaixo é a consulta na entidade dos paciente 'original'
//    @GetMapping
//    public List<Paciente> getPaciente(@QuerydslPredicate(root = Paciente.class) Predicate predicate) {
//        List<Paciente> result = new ArrayList<>();
//        Iterable<Paciente> all = repository.findAll(predicate);
//        all.forEach(f -> result.add(f));
//        return (result);
//    }

    //Abaixo é a consulta na entidade dos PacienteDTO
    @GetMapping
    @ApiOperation(value="Retorna a lista de pacientes")
    public List<PacienteDTO> getPaciente(@QuerydslPredicate(root = Paciente.class) Predicate predicate) {
        List<PacienteDTO> result = new ArrayList<>();
        Iterable<Paciente> all = repository.findAll(predicate);
        all.forEach(f -> result.add(PacienteDTO.toDTO(f)));
        return (result);
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Retorna apenas um paciente por vez")
    public PacienteDTO getPacienteId(@PathVariable(value = "id") Long id) throws EntityNotFoundException {

        Paciente pacienteFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com ID :: " + id));

        return PacienteDTO.toDTO(pacienteFind);
    }

    @PostMapping
    @ApiOperation(value="Cria um paciente")
    public Paciente create(@Valid @RequestBody Paciente paciente) throws ValidationException {

        List<Paciente> byCpf = repository.findByCpf(paciente.getCpf());

        if (!byCpf.isEmpty()) {
            throw new ValidationException("Já existe um paciente com o mesmo CPF registrado!");
        }

        return repository.save(paciente);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza um paciente por vez")
    public Paciente update(@PathVariable(value = "id") Long id,
                         @RequestBody Paciente paciente) throws EntityNotFoundException {
        Paciente pacienteFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com ID: " + id));

        pacienteFind.setNome(paciente.getNome());
        pacienteFind.setCpf(paciente.getCpf());
        pacienteFind.setDataNascimento(paciente.getDataNascimento());

        /*
        Optional<Paciente> one = repository.findOne(QPaciente.paciente.nome.eq(paciente.getNome()));
        if(one.isPresent()){
            throw new ValidationException("Não é possível registrar com o mesmo Nome!");
        }
         */

        return repository.save(pacienteFind);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Exclui um paciente por vez")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        Paciente pacienteFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com ID :: " + id));

        repository.delete(pacienteFind);

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
