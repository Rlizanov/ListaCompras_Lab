package pe.cibertec.MiDemoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.MiDemoApp.modelo.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);
}
