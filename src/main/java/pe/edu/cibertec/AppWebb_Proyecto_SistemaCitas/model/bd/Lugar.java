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
@Table(name = "lugar")
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdLugar;
    @Column(name = "Ciudad")
    private String Ciudad;
    @Column(name = "Distrito")
    private String Distrito;
}


