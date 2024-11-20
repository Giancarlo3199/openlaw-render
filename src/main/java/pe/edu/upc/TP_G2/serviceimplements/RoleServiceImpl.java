package pe.edu.upc.TP_G2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.TP_G2.entities.Role;
import pe.edu.upc.TP_G2.repositories.RoleRepository;
import pe.edu.upc.TP_G2.servicesinterfaces.RoleService;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(String rol) {
        return roleRepository.findByRol(rol);
    }
}
