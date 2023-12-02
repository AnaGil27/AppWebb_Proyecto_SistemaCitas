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
@Table(name = "manicura")
public class Manicura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmanicura;
    @Column(name = "preciomanicura")
    private String preciomanicura;
    @Column(name = "tiempomanicura")
    private String tiempomanicura;

    @OneToOne
    @JoinColumn(name = "iddescmanicura")
    private DescManicura descmanicura;

    @Column(name="descripcion")
    private String descripcion;

}
