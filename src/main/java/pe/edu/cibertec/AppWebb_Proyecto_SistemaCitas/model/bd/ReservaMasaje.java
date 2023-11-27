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
@Table(name="reservamasaje")
public class ReservaMasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva_masaje;

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
    @JoinColumn(name="id_masaje")
    private Masaje masaje;

    @Column(name="fechaJ")
    private String fechaJ;

}
