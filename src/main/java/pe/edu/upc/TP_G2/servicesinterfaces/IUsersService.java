package pe.edu.upc.TP_G2.servicesinterfaces;

import pe.edu.upc.TP_G2.entities.Users;

import java.util.List;

public interface IUsersService {
    public void insert(Users users);
    public List<Users>listar();
    public void delete(Long id);
    public Users listarId(Long id);
}
