package pe.cibertec.MiDemoApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.MiDemoApp.modelo.ItemLista;
import pe.cibertec.MiDemoApp.modelo.ListaCompra;
import pe.cibertec.MiDemoApp.modelo.Usuario;
import pe.cibertec.MiDemoApp.repository.ItemListaRepository;
import pe.cibertec.MiDemoApp.repository.ListaCompraRepository;
import pe.cibertec.MiDemoApp.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("api/listas")
@RequiredArgsConstructor
public class ListCompraController {

    private final ListaCompraRepository listaCompraRepo;
    private final ItemListaRepository itemListaRepo;
    private final UsuarioRepository usuarioRepo;

    @PostMapping("/id/{idUsuario}/crear")
    public ResponseEntity<?> crear (@PathVariable Long idUsuario, @RequestBody ListaCompra listaCompra){
        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        if(usuario==null){
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
        listaCompra.setUsuario(usuario);
        return  ResponseEntity.ok(listaCompraRepo.save(listaCompra));
    }

    @PostMapping("/{idLista}/agregar")
    public ResponseEntity<?> agregarItem(@PathVariable Long idLista, @RequestBody ItemLista itemLista){
        ListaCompra listaCompra = listaCompraRepo.findById(idLista).orElse(null);
        if(listaCompra==null){
            return ResponseEntity.notFound().build();
        }
        itemLista.setLista(listaCompra);
        return ResponseEntity.ok(itemListaRepo.save(itemLista));

    }

    @PutMapping("/item/{id}/cambiar-estado")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long idItem, @RequestParam String estado){
        return  itemListaRepo.findById(idItem)
                .map( item -> {
                    item.setEstado(estado);
                    return ResponseEntity.ok(itemListaRepo.save(item));
                }).orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/usuario/{id}")
    public List<ListaCompra> historial (@PathVariable Long idUsuario){
        return listaCompraRepo.findByUsuarioId(idUsuario);
    }

}
