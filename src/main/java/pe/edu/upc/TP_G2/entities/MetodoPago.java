package pe.edu.upc.TP_G2.entities;

import javax.persistence.*;

@Entity
@Table(name = "MetodoPago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodoPago;
    @Column(name = "tipoPago",length = 25,nullable = false)
    private String tipoPago;

    @ManyToOne
    @JoinColumn(name = "idUser")            //VALIDAR, a veces hay errores por este nombre
    private Users user;

    public MetodoPago() {
    }

    public MetodoPago(int idMetodoPago, String tipoPago, Users user) {
        this.idMetodoPago = idMetodoPago;
        this.tipoPago = tipoPago;
        this.user = user;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
