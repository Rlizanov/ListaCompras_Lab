package pe.cibertec.MiDemoApp.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Version
    private Integer version;
}
