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
    private Integer idmaquillaje;
    @Column(name="preciomaquillaje")
    private String preciomaquillaje;
    @Column(name="tiempomaquillaje")
    private String tiempomaquillaje;

    @OneToOne
    @JoinColumn(name="iddescmaquillaje")
    private DescMaquillaje descmaquillaje;

    @Column(name="descripcion")
    private String descripcion;

}
