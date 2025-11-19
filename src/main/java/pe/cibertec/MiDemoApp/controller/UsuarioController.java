package pe.cibertec.MiDemoApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.MiDemoApp.repository.UsuarioRepository;
import pe.cibertec.MiDemoApp.modelo.Usuario;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    UsuarioRepository usuarioRepo;

    public UsuarioController(UsuarioRepository usuarioRepo){
        this.usuarioRepo=usuarioRepo;
    }

    // Registrar Nuevo usuario

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar (@RequestBody Usuario usuario){
        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        return ResponseEntity.ok(usuarioGuardado);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioRepo.findAll();
    }

    @GetMapping("api/usuarios/{id}")
    public  ResponseEntity<Usuario> buscar(@PathVariable Long id){
        return usuarioRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound()
                        .build());
    }
}
