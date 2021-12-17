package bethacode.clinimais.resource;


import bethacode.clinimais.enterprise.Response;
import bethacode.clinimais.enterprise.ValidationException;
import bethacode.clinimais.model.Usuario;
import bethacode.clinimais.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController extends AbstractResource {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getUsuario() {
        return repository.findAll();
    }

    @PostMapping
    public Usuario create(@Valid @RequestBody Usuario usuario) throws ValidationException {

        List<Usuario> byUsuario = repository.findByUsuario(usuario.getUsuario());

        if (!byUsuario.isEmpty()) {
            throw new ValidationException("Já existe um usuário com o mesmo nome registrado!");
        }

        return repository.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logar(@Valid @RequestBody Usuario usuario) throws ValidationException {

        List<Usuario> byLogin = repository.findByUsuario(usuario.getUsuario());

        if (!byLogin.isEmpty()) {
            Usuario userBack = byLogin.get(0);
            if (userBack.getUsuario().equals(usuario.getUsuario()) && userBack.getSenha().equals(usuario.getSenha())) {
                return ResponseEntity.ok().build();
            } else {
                Response message = new Response("Senha incorreta");
                return ResponseEntity.status(401).body(message);
            }
        }else {
            Response message = new Response("Usuário não encontrado");
            return ResponseEntity.status(401).body(message);
        }

    }
        /*
        if (!byLogin.isEmpty()) {
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(401).build();
        }
        */

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