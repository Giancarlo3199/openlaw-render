package pe.edu.upc.TP_G2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.TP_G2.entities.Suscripcion;
import pe.edu.upc.TP_G2.repositories.SuscripcionRepository;
import pe.edu.upc.TP_G2.servicesinterfaces.SuscripcionService;

import java.util.List;

@Service
public class SuscripcionServiceImplemnt implements SuscripcionService {

    @Autowired
    private SuscripcionRepository sR;

    @Override
    public void insert(Suscripcion suscripcion) {
        sR.save(suscripcion);
    }

    @Override
    public List<Suscripcion> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int idSus) {
        sR.deleteById(idSus);
    }

    @Override
    public Suscripcion listarId(int idSus) {
        return sR.findById(idSus).orElse(new Suscripcion());
    }
}
