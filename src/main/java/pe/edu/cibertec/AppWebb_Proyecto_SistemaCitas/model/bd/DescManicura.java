package pe.edu.cibertec.AppWebb_Proyecto_SistemaCitas.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "descmanicura")
public class DescManicura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddescmanicura;
    @Column(name = "nombremanicura")
    private String nombremanicura;
}
