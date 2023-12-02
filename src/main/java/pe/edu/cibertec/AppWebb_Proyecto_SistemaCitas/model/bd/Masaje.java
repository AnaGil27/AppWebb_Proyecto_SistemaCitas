package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="masaje")
public class Masaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmasaje;
    @Column(name = "tiempomasaje")
    private String tiempomasaje;
    @Column(name = "preciomasaje")
    private String preciomasaje;


    @OneToOne
    @JoinColumn(name = "iddescmasaje")
    private DescMasaje descmasaje;

    @Column(name="descripcion")
    private String descripcion;
}