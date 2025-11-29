package pe.cibertec.MiDemoApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.MiDemoApp.dto.LoginRequest;
import pe.cibertec.MiDemoApp.modelo.Usuario;
import pe.cibertec.MiDemoApp.repository.UsuarioRepository;

@RestController
@RequestMapping("api/auth")

public class AuthController {

    private final UsuarioRepository usuarioRepo;

    public AuthController( UsuarioRepository usuarioRepo){
        this.usuarioRepo=usuarioRepo;
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody LoginRequest loginRequest){
        Usuario usuario=usuarioRepo.findByCorreo(loginRequest.getCorreo()).orElse(null);
        if(usuario==null || !usuario.getClave().equals(loginRequest.getClave())){
            return ResponseEntity.status(401).body("credenciales invalidas");
        }
        return  ResponseEntity.ok(usuario);
    }

}
