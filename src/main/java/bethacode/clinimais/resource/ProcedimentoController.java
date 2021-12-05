package bethacode.clinimais.resource;



import bethacode.clinimais.enterprise.ValidationException;
import bethacode.clinimais.model.Paciente;
import bethacode.clinimais.model.QProcedimento;
import bethacode.clinimais.model.Procedimento;
import bethacode.clinimais.repository.ProcedimentoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/procedimento")
@Api(value="Rest Procedimentos")
@CrossOrigin(origins="*")
public class ProcedimentoController {
    @Autowired
    private ProcedimentoRepository repository;

    @GetMapping
    @ApiOperation(value="Retorna a lista de procedimentos")
    public List<Procedimento> getProcedimento() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ProcedimentoDTO getProcedimentoId(@PathVariable(value = "id") Long id) throws EntityNotFoundException {

        Procedimento procedimentoFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Procedimento não encontrado com ID :: " + id));

        return ProcedimentoDTO.toDTO(procedimentoFind);
    }

    @PostMapping
    public Procedimento create(@Valid @RequestBody Procedimento procedimento) throws ValidationException{
        List<Procedimento> byDescricao = repository.findByDescricao(procedimento.getDescricao());

        /*
        if (!byDescricao.isEmpty()) {
            throw new ValidationException("Já existe um procedimento com a mesma descrição registrada!");
        }
        */

        return repository.save(procedimento);
    }

    @PutMapping("/{id}")
    public Procedimento update(@PathVariable(value = "id") Long id,
                           @RequestBody Procedimento procedimento) throws EntityNotFoundException, ValidationException {
        Procedimento procedimentoFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Procedimento não encontrado com ID: " + id));

        procedimentoFind.setDescricao(procedimento.getDescricao());

        /*
        List<Procedimento> byDescricao = repository.findByDescricao(procedimento.getDescricao());

        if (!byDescricao.isEmpty()) {
            throw new ValidationException("Já existe um procedimento com a mesma descrição registrada!");
        }
        */

        return repository.save(procedimentoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        Procedimento procedimentoFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Procedimento não encontrado com ID :: " + id));

        repository.delete(procedimentoFind);

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
