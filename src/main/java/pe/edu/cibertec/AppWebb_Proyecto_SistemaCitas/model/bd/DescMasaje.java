package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "descmasaje")
public class DescMasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddescmasaje;
    @Column(name = "nombremasaje")
    private String nombremasaje;
}