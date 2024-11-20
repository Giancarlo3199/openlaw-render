package pe.edu.upc.TP_G2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.TP_G2.entities.MetodoPago;
import pe.edu.upc.TP_G2.repositories.MetodoPagoRepository;
import pe.edu.upc.TP_G2.servicesinterfaces.MetodoPagoService;

import java.util.List;

@Service
public class MetodoPagoServiceImplement implements MetodoPagoService {

    @Autowired
    private MetodoPagoRepository mR;

    @Override
    public void insert(MetodoPago metodoPago) {
        mR.save(metodoPago);
    }

    @Override
    public List<MetodoPago> listar() {
        return mR.findAll();
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public MetodoPago listarId(int id) {
        return mR.findById(id).orElse(new MetodoPago());
    }

    @Override
    public List<String[]> cantidadUsuariosPorMetodoPago() {
        return mR.cantidadUsuariosPorMetodoPago();
    }
}
