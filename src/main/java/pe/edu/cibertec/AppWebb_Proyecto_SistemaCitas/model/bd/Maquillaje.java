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
@Table(name="maquillaje")
public class Maquillaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_maquillaje;
    @Column(name="precio_maquillaje")
    private String precio_maquillaje;
    @Column(name="tiempo_maquillaje")
    private String tiempo_maquillaje;

    @OneToOne
    @JoinColumn(name="id_desc_maquillaje")
    private DescMaquillaje descmaquillaje;
}
