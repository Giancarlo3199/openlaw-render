package pe.edu.upc.TP_G2.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DocumentoLegal")
public class DocumentoLegal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumento;
    @Column(name = "tipoDocumento", length = 30, nullable = false)
    private String tipoDocumento;
    @Column(name = "tituloDocumento", length = 250, nullable = false)
    private String tituloDocumento;
    @Column(name = "descripcionDocumento", length = 900, nullable = false)
    private String descripcionDocumento;
    @Column(name = "urlDocumento", length = 250, nullable = false)
    private String urlDocumento;
    @Column(name = "fechaPublicacion", nullable = false)
    private LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;

    public DocumentoLegal() {
    }

    public DocumentoLegal(int idDocumento, String tipoDocumento, String tituloDocumento, String descripcionDocumento, String urlDocumento, LocalDate fechaPublicacion, Users user) {
        this.idDocumento = idDocumento;
        this.tipoDocumento = tipoDocumento;
        this.tituloDocumento = tituloDocumento;
        this.descripcionDocumento = descripcionDocumento;
        this.urlDocumento = urlDocumento;
        this.fechaPublicacion = fechaPublicacion;
        this.user = user;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTituloDocumento() {
        return tituloDocumento;
    }

    public void setTituloDocumento(String tituloDocumento) {
        this.tituloDocumento = tituloDocumento;
    }

    public String getDescripcionDocumento() {
        return descripcionDocumento;
    }

    public void setDescripcionDocumento(String descripcionDocumento) {
        this.descripcionDocumento = descripcionDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setUrlDocumento(String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
