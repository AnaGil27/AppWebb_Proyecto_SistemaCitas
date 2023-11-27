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
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empleado;
    @Column(name = "nom_empleado")
    private String nom_empleado;
    @Column(name = "ape_empleado")
    private String ape_empleado;
    @Column(name = "celular_empleado")
    private String celular_empleado;

    @OneToOne
    @JoinColumn(name="id_lugar")
    private Lugar lugar;
}
