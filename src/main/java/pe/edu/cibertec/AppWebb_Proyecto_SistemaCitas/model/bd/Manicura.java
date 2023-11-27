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
    private Integer id_manicura;
    @Column(name = "precio_manicura")
    private String precio_manicura;
    @Column(name = "tiempo_manicura")
    private String tiempo_manicura;

    @OneToOne
    @JoinColumn(name = "id_desc_manicura")
    private DescManicura descmanicura;

    @Column(name="descripcion")
    private String descripcion;

}
