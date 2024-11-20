package pe.edu.upc.TP_G2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.TP_G2.entities.Users;
import pe.edu.upc.TP_G2.repositories.UsersRepository;
import pe.edu.upc.TP_G2.servicesinterfaces.IUsersService;


import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private UsersRepository uR;
    @Override
    public void insert(Users users) {
        uR.save(users);
    }

    @Override
    public List<Users> listar() {
        return uR.findAll();
    }

    @Override
    public void delete(Long id) {
        uR.deleteById(id);
    }

    @Override
    public Users listarId(Long id) {
        return uR.findById(id).orElse(new Users());
    }

}
