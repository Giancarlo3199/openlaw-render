package pe.edu.upc.TP_G2.servicesinterfaces;

import pe.edu.upc.TP_G2.entities.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String rol);
}
