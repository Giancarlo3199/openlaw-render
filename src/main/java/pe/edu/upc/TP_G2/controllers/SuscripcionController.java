package pe.edu.upc.TP_G2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.TP_G2.dtos.SuscripcionDTO;
import pe.edu.upc.TP_G2.entities.Suscripcion;
import pe.edu.upc.TP_G2.servicesinterfaces.SuscripcionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Suscripcion")
public class SuscripcionController {

    @Autowired
    private SuscripcionService sS;

    @PostMapping
    public void registrar(@RequestBody SuscripcionDTO dto) {
        ModelMapper m = new ModelMapper();
        Suscripcion mb = m.map(dto, Suscripcion.class);
        sS.insert(mb);
    }

    @GetMapping
    public List<SuscripcionDTO> listar() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SuscripcionDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        sS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody SuscripcionDTO dto) {
        ModelMapper m = new ModelMapper();
        Suscripcion ms = m.map(dto, Suscripcion.class);
        sS.insert(ms);
    }

    @GetMapping("/{id}")
    public SuscripcionDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        SuscripcionDTO dto=m.map(sS.listarId(id),SuscripcionDTO.class);
        return dto;
    }
}
