package pe.edu.upc.TP_G2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.TP_G2.dtos.UsersDTO;
import pe.edu.upc.TP_G2.entities.Users;
import pe.edu.upc.TP_G2.servicesinterfaces.IUsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService uS;

    @PostMapping
    public void registrar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto,Users.class);
        uS.insert(u);
    }

    @GetMapping
    public List<UsersDTO> listar(){
        return uS.listar().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsersDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(uS.listarId(id),UsersDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        uS.delete(id);
    }

    /*@PutMapping
    public void actualizar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u=m.map(dto,Users.class);
        uS.insert(u);
    }*/
    @PutMapping("/{id}")
    public void actualizar(@PathVariable("id") Long id, @RequestBody UsersDTO dto) {
        Users usuarioExistente = uS.listarId(id);

        if (usuarioExistente != null) {
            usuarioExistente.setUsername(dto.getUsername());
            usuarioExistente.setPassword(dto.getPassword());
            usuarioExistente.setEnabled(dto.getEnabled());
            usuarioExistente.setNombres(dto.getNombres());
            usuarioExistente.setApellidos(dto.getApellidos());
            usuarioExistente.setGenero(dto.getGenero());
            usuarioExistente.setEmail(dto.getEmail());
            usuarioExistente.setDni(dto.getDni());
            usuarioExistente.setCelular(dto.getCelular());
            usuarioExistente.setFechaRegistro(dto.getFechaRegistro());  //VALIDAR si no hay problema con la fecha
            uS.insert(usuarioExistente);
        }
    }
}
