package br.com.rd.ProjetoServico.Repository.contract;

import br.com.rd.ProjetoServico.Model.Entity.Bike;
import br.com.rd.ProjetoServico.Model.Entity.Car;
import br.com.rd.ProjetoServico.Model.Entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

public interface VehicleRepositoryCustom {
//    List<Vehicle> findAllByYear(Integer year);

    //@Modifying quando for para fazer insert/update/delete
//    @Query(value = "SELECT * FROM vehicle v " +
//                        "left join bike b on v.id = b.id " +
//                        "left join car c on v.id = c.id " +
//                        "WHERE v.YEAR > :year", nativeQuery = true)
//    List<Vehicle> abobrinha(@Param("year")Integer year);

    List<Vehicle> abobrinha(Integer year);
}
