package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdReserva;

    @OneToOne
    @JoinColumn(name="idusuario")
    private Usuario usuario;

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

    @OneToOne
    @JoinColumn(name="IdEmpleado")
    private Empleado empleado;

    @OneToOne
    @JoinColumn(name="IdLugar")
    private Lugar lugar;

    @Column(name="FechaReserva")
    private String FechaReserva;


}
