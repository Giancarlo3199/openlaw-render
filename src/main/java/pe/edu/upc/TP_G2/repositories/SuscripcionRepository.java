package pe.edu.upc.TP_G2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.TP_G2.entities.Suscripcion;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion,Integer> {

}
