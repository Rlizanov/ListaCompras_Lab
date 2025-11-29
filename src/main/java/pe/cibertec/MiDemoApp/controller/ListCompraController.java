package pe.cibertec.MiDemoApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.MiDemoApp.modelo.ListaCompra;
import pe.cibertec.MiDemoApp.modelo.Usuario;
import pe.cibertec.MiDemoApp.repository.ItemListaRepository;
import pe.cibertec.MiDemoApp.repository.ListaCompraRepository;
import pe.cibertec.MiDemoApp.repository.UsuarioRepository;

@RestController
@RequestMapping("api/listas")
@RequiredArgsConstructor
public class ListCompraController {

    ListaCompraRepository listaCompraRepo;
    ItemListaRepository itemListaRepos;
    UsuarioRepository usuarioRepo;

    @PostMapping("id/{idUsuario}/crear")
    public ResponseEntity<?> crear (@PathVariable Long idUsuario, @RequestBody ListaCompra listaCompra){
        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        if(usuario==null){
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }
        listaCompra.setUsuario(usuario);
        return  ResponseEntity.ok(listaCompraRepo.save(listaCompra));
    }

}
