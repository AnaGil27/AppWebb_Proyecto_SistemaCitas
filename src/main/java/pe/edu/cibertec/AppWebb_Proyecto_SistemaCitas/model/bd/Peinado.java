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
@Table(name="peinado")
public class Peinado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_peinado;
    @Column(name="precio_peinado")
    private String precio_peinado;
    @Column(name="tiempo_peinado")
    private String tiempo_peinado;

    @OneToOne
    @JoinColumn(name="id_desc_peinado")
    private DescPeinado descpeinado;

    @Column(name="descripcion")
    private String descripcion;
}