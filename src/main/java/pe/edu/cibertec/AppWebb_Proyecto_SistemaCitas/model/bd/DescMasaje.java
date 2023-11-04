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
    private Integer id_desc_masaje;
    @Column(name = "desc_masaje")
    private String desc_masaje;
}