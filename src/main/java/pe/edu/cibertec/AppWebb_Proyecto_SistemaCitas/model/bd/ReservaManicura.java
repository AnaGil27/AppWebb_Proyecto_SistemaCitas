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
@Table(name="reservamanicura")

public class ReservaManicura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva_manicura;

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
    @JoinColumn(name="idmanicura")
    private Manicura manicura;

    @Column(name="fechaM")
    private String fechaM;


}