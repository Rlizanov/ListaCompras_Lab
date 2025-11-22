package pe.cibertec.MiDemoApp.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.MiDemoApp.modelo.Producto;
import pe.cibertec.MiDemoApp.repository.ProductoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepo;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void registrarLote(List<Producto> productos){
        int i=0;
        for (Producto producto:productos){
            em.persist(producto);
            i++;
            if(i%10==0){
                em.flush();
                em.clear();
            }
        }
    }

    public List<Producto> ListarTodos(){
        return em.createQuery("SELECT p FROM Producto p",Producto.class)
                .setHint("org.hibernate.fetchSize", 5)
                .getResultList();
    }

}
