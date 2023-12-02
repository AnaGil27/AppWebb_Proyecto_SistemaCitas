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
@Table(name="reservapeinado")
public class ReservaPeinado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reservaPeinado;

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
    @JoinColumn(name="idpeinado")
    private Peinado peinado;

    @Column(name="fechaP")
    private String fechaP;


}
