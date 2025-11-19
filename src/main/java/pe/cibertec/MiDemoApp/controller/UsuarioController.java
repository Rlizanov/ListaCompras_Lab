package pe.cibertec.MiDemoApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.MiDemoApp.repository.UsuarioRepository;
import pe.cibertec.MiDemoApp.modelo.Usuario;

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
}
