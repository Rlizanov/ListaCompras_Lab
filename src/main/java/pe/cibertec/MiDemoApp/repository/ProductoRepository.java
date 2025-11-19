package pe.cibertec.MiDemoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.MiDemoApp.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
