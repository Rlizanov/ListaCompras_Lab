package pe.cibertec.MiDemoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.MiDemoApp.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
