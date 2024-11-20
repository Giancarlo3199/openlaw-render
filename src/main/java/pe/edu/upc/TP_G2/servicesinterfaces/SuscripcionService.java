package pe.edu.upc.TP_G2.servicesinterfaces;

import pe.edu.upc.TP_G2.entities.Suscripcion;

import java.util.List;

public interface SuscripcionService {
    public void insert(Suscripcion suscripcion);
    public List<Suscripcion> list();
    public void delete(int idSus);
    public Suscripcion listarId(int idSus);
}
