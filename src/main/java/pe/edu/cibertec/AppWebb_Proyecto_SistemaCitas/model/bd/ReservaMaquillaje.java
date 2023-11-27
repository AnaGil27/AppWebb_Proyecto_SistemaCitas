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
@Table(name="reservamaquillaje")
public class ReservaMaquillaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva_maquillaje;

    @OneToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="id_lugar")
    private Lugar lugar;

    @OneToOne
    @JoinColumn(name="id_empleado")
    private Empleado empleado;

    @OneToOne
    @JoinColumn(name="id_maquillaje")
    private Maquillaje maquillaje;

    @Column(name="fechaP")
    private String fechaP;


}
