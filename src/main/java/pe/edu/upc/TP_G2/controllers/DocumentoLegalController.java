package pe.edu.upc.TP_G2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.TP_G2.dtos.DocumentoLegalDTO;
import pe.edu.upc.TP_G2.entities.DocumentoLegal;
import pe.edu.upc.TP_G2.servicesinterfaces.DocumentoLegalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DocumentoLegal")
public class DocumentoLegalController {

    @Autowired
    private DocumentoLegalService dS;

    @PostMapping
    public void registrar(@RequestBody DocumentoLegalDTO dto) {
        ModelMapper m = new ModelMapper();
        DocumentoLegal md = m.map(dto, DocumentoLegal.class);
        dS.insert(md);
    }

    @GetMapping
    public List<DocumentoLegalDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DocumentoLegalDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        dS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody DocumentoLegalDTO dto) {
        ModelMapper m = new ModelMapper();
        DocumentoLegal mb = m.map(dto, DocumentoLegal.class);
        dS.insert(mb);
    }

    @GetMapping("/{id}")
    public DocumentoLegalDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        DocumentoLegalDTO dto=m.map(dS.listarId(id),DocumentoLegalDTO.class);
        return dto;
    }
}
