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
@Table(name="servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdServicios;

    @OneToOne
    @JoinColumn(name="id_manicura")
    private Manicura manicura;

    @OneToOne
    @JoinColumn(name="id_peinado")
    private Peinado peinado;

    @OneToOne
    @JoinColumn(name="id_masaje")
    private Masaje masaje;

    @OneToOne
    @JoinColumn(name="id_maquillaje")
    private Maquillaje maquillaje;


}
