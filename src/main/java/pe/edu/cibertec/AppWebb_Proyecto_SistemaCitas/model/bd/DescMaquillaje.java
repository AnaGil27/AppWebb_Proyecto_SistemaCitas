package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd;

import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@Entity
@Table(name="descmaquillaje")

public class DescMaquillaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddescmaquillaje;
    @Column(name="nombremaquillaje")
    private String nombremaquillaje;
}
