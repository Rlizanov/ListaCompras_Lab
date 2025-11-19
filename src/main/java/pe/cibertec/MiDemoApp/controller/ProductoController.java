package pe.cibertec.MiDemoApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.MiDemoApp.modelo.Producto;
import pe.cibertec.MiDemoApp.modelo.Usuario;
import pe.cibertec.MiDemoApp.repository.ProductoRepository;
import pe.cibertec.MiDemoApp.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    ProductoRepository productoRepo;

    public ProductoController(ProductoRepository productoRepo){
        this.productoRepo=productoRepo;
    }

    // Registrar Nuevo usuario

    @PostMapping("/registro")
    public ResponseEntity<Producto> registrar (@RequestBody Producto producto){
        Producto productoGuardado = productoRepo.save(producto);
        return ResponseEntity.ok(productoGuardado);
    }
}
