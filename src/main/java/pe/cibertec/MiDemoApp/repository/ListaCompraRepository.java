package pe.cibertec.MiDemoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.MiDemoApp.modelo.ListaCompra;

import java.util.List;

public interface ListaCompraRepository extends JpaRepository {
    List<ListaCompra> findByUsuarioId(Long idUsuario);

    }
