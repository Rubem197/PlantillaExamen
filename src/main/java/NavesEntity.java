import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VQ_Naves")
public class NavesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ganadero")
    private String ganadero;

    @Column(name = "ubicacion")
    private String ubicacion;


    public NavesEntity() {

    }

    public NavesEntity(String ganadero, String ubicacion) {
        this.ganadero = ganadero;
        this.ubicacion = ubicacion;
    }

    public String getGanadero() {
        return ganadero;
    }

    public void setGanadero(String ganadero) {
        this.ganadero = ganadero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
