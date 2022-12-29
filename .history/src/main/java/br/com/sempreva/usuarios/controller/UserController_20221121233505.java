package br.com.sempreva.usuarios.controller;

import br.com.sempreva.usuarios.dto.UserDto;
import br.com.sempreva.usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping
    public Page<UserDto> listar(@PageableDefault(size = 10) Pageable pagination) {
        return service.getUsers(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> detalhar(@PathVariable @NotNull Long id) {
        UserDto dto = service.getUserById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UserDto> cadastrar(@RequestBody @Valid UserDto dto, UriComponentsBuilder uriBuilder) {
        UserDto pagamento = service.createUser(dto);
        URI endereco = uriBuilder.path("/user/{id}").buildAndExpand(pagamento.getId()).toUri();

        return ResponseEntity.created(endereco).body(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid UserDto dto) {
        UserDto atualizado = service.updateUser(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> remover(@PathVariable @NotNull Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
