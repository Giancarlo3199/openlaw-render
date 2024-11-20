package pe.edu.upc.TP_G2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.TP_G2.entities.MetodoPago;

import java.util.List;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

    @Query(value = "select mp.tipo_pago, count(*) from users u join metodo_pago mp\n" +
            " on u.id = mp.id_user \n" +
            " group by mp.tipo_pago", nativeQuery = true)
    List<String[]> cantidadUsuariosPorMetodoPago();
}
