package pe.cibertec.MiDemoApp.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="item_lista")
public class ItemLista {

    private Long id;

    private String nombreProducto;

    private Integer cantidad;

    private String estado = "PENDIENTE";

    @ManyToOne
    @JoinColumn(name = "lista_id")
    @JsonIgnore
    private  ListaCompra lista;
}
