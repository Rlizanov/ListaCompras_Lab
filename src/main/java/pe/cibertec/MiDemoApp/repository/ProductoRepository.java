package pe.cibertec.MiDemoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.cibertec.MiDemoApp.modelo.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM P WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :texto,'%'))")
    List<Producto> obtenerPorNombre(@Param("texto") String texto);
}


