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
    private Integer idpeinado;
    @Column(name="preciopeinado")
    private String preciopeinado;
    @Column(name="tiempopeinado")
    private String tiempopeinado;

    @OneToOne
    @JoinColumn(name="iddescpeinado")
    private DescPeinado descpeinado;

    @Column(name="descripcion")
    private String descripcion;
}