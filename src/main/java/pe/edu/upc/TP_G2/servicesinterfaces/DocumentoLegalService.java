package pe.edu.upc.TP_G2.servicesinterfaces;

import pe.edu.upc.TP_G2.entities.DocumentoLegal;

import java.util.List;

public interface DocumentoLegalService {
    public void insert(DocumentoLegal docLegal);
    public List<DocumentoLegal> list();
    public void delete(int idDoc);
    public DocumentoLegal listarId(int idDoc);
}
