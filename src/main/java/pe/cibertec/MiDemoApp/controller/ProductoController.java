package pe.cibertec.MiDemoApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.MiDemoApp.modelo.Producto;
import pe.cibertec.MiDemoApp.modelo.Usuario;
import pe.cibertec.MiDemoApp.repository.ProductoRepository;
import pe.cibertec.MiDemoApp.repository.UsuarioRepository;
import pe.cibertec.MiDemoApp.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoRepository productoRepo;
    private final ProductoService productoService;


    // Registrar Nuevo usuario

    @PostMapping("/registro")
    public ResponseEntity<Producto> registrar (@RequestBody Producto producto){
        Producto productoGuardado = productoRepo.save(producto);
        return ResponseEntity.ok(productoGuardado);
    }

    //
}
