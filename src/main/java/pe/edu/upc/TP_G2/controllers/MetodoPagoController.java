package pe.edu.upc.TP_G2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.TP_G2.dtos.CantuserXmetPagoDTO;
import pe.edu.upc.TP_G2.dtos.MetodoPagoDTO;
import pe.edu.upc.TP_G2.entities.MetodoPago;
import pe.edu.upc.TP_G2.servicesinterfaces.MetodoPagoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/MetodoPago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService mS;

    @PostMapping
    public void registrar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mS.insert(mp);
    }

    @GetMapping
    public List<MetodoPagoDTO> listar() {
        return mS.listar().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        mS.delete(id);
    }

    @PutMapping
    public void actualizar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mP = m.map(dto, MetodoPago.class);
        mS.insert(mP);
    }

    @GetMapping("/{id}")
    public MetodoPagoDTO listarId(@PathVariable("id") Integer id) {  //Validar si no hay problema por el integer
        ModelMapper m=new ModelMapper();
        MetodoPagoDTO dto=m.map(mS.listarId(id),MetodoPagoDTO.class);
        return dto;
    }

    @GetMapping("/CantidadUsersXtipo")
    public List<CantuserXmetPagoDTO> cantidadTotalDeDispositivosPortioDeDispositivo() {
        List<String[]> lista = mS.cantidadUsuariosPorMetodoPago();
        List<CantuserXmetPagoDTO> listaDTO = new ArrayList<>();
        for (String[] data : lista) {
            CantuserXmetPagoDTO dto = new CantuserXmetPagoDTO();
            dto.setNameTipo(data[0]);
            dto.setCantidad(Integer.parseInt(data[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
