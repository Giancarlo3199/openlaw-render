package pe.edu.upc.TP_G2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.TP_G2.entities.DocumentoLegal;
import pe.edu.upc.TP_G2.repositories.DocumentoLegaRepository;
import pe.edu.upc.TP_G2.servicesinterfaces.DocumentoLegalService;

import java.util.List;

@Service
public class DocumentoLegalServiceImplement implements DocumentoLegalService {

    @Autowired
    private DocumentoLegaRepository dR;

    @Override
    public void insert(DocumentoLegal docLegal) {
        dR.save(docLegal);
    }

    @Override
    public List<DocumentoLegal> list() {
        return dR.findAll();
    }

    @Override
    public void delete(int idDoc) {
        dR.deleteById(idDoc);
    }

    @Override
    public DocumentoLegal listarId(int idDoc) {
        return dR.findById(idDoc).orElse(new DocumentoLegal());
    }
}
