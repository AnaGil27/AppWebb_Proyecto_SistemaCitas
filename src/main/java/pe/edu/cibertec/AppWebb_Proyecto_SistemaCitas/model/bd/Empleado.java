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
    private Integer IdEmpleado;
    @Column(name = "NomEmpleado")
    private String NomEmpleado;
    @Column(name = "ApeEmpleado")
    private String ApeEmpleado;
    @Column(name = "CelularEmpleado")
    private String CelularEmpleado;
}
