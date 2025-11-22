package pe.cibertec.MiDemoApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.MiDemoApp.modelo.Producto;
import pe.cibertec.MiDemoApp.modelo.Usuario;
import pe.cibertec.MiDemoApp.repository.ProductoRepository;
import pe.cibertec.MiDemoApp.repository.UsuarioRepository;
import pe.cibertec.MiDemoApp.service.ProductoService;

import java.util.List;

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

    //Registrar Lote
    @PostMapping("/lote")
    public ResponseEntity<String> registrarLote (@RequestBody List<Producto> productoList){
        productoService.registrarLote(productoList);
        System.out.printf("Paso por aqui");
        return  ResponseEntity.ok("Productos registrados exitosamente");
    }

    //Listar Todos los productos

    @GetMapping
    public List<Producto> ListarProductosLote(){
        return productoService.ListarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id){
        return productoRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound()
                        .build());
    }

    //ACTUALIAR PRODUCT
    @PutMapping("/edit/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto productoDetalles){
        return productoRepo.findById(id)
                .map(prodExistente -> {
                    // Actualizamos los datos con lo que viene en el JSON
                    prodExistente.setNombre(productoDetalles.getNombre());
                    prodExistente.setPrecio(productoDetalles.getPrecio());

                    // Guardamos los cambios
                    Producto productoActualizado = productoRepo.save(prodExistente);
                    return ResponseEntity.ok(productoActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
