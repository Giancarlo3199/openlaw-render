package pe.edu.upc.TP_G2.servicesinterfaces;

import pe.edu.upc.TP_G2.entities.MetodoPago;
import pe.edu.upc.TP_G2.entities.Users;

import java.util.List;

public interface MetodoPagoService {

    void insert(MetodoPago metodoPago);
    public List<MetodoPago> listar();
    public void delete(int id);
    public MetodoPago listarId(int id);
    List<String[]> cantidadUsuariosPorMetodoPago();
}
