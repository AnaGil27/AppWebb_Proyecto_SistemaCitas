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
    private Integer id_masaje;
    @Column(name = "tiempo_masaje")
    private String tiempo_masaje;
    @Column(name = "precio_masaje")
    private String precio_masaje;


    @OneToOne
    @JoinColumn(name = "id_desc_masaje")
    private DescMasaje descmasaje;

    @Column(name="descripcion")
    private String descripcion;
}