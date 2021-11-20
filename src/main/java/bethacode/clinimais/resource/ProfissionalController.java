package bethacode.clinimais.resource;

import bethacode.clinimais.model.Profissional;
import bethacode.clinimais.repository.ProfissionalRepository;
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
@RequestMapping("api/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;

    @GetMapping
    public List<Profissional> getProfissional() {
        return repository.findAll();
    }

    @PostMapping
    public Profissional create(@Valid @RequestBody Profissional profissional){
        return repository.save(profissional);
    }

    @GetMapping("/{id}")
    public ProfissionalDTO getProfissionalId(@PathVariable(value = "id") Long id) throws EntityNotFoundException {

        Profissional profissionalFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado com ID :: " + id));

        return ProfissionalDTO.toDTO(profissionalFind);
    }

    @PutMapping("/{id}")
    public Profissional update(@PathVariable(value = "id") Long id,
                           @RequestBody Profissional profissional) throws EntityNotFoundException {
        Profissional profissionalFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado com ID: " + id));

        profissionalFind.setNome(profissional.getNome());
        profissionalFind.setTipoProfissional(profissional.getTipoProfissional());

        return repository.save(profissionalFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        Profissional profissionalFind = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado com ID :: " + id));

        repository.delete(profissionalFind);

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
