package br.com.rd.ProjetoServico.Repository.implementation;

import br.com.rd.ProjetoServico.Model.DTO.VehicleDTO;
import br.com.rd.ProjetoServico.Model.Entity.Bike;
import br.com.rd.ProjetoServico.Model.Entity.Car;
import br.com.rd.ProjetoServico.Model.Entity.Vehicle;
import br.com.rd.ProjetoServico.Repository.contract.VehicleRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements VehicleRepositoryCustom
{
    //https://dzone.com/articles/add-custom-functionality-to-a-spring-data-reposito
    @PersistenceContext //Similar ao @Autowired porém com gerenciamento de conexões multiplas (Apenas para o EntityManager)
    EntityManager entityManager; //quem gerencia toda a conexão com a base de dados

//    @Override
//    public List<Vehicle> findAllByYear(Integer year){
//        //Retornando um único objeto
////        Query sql = entityManager.createNativeQuery("SELECT * FROM vehicle WHERE ID = 1", Vehicle.class);
////        Vehicle v = (Vehicle) sql.getResultList().get(0);
//        //Query sql = entityManager.createNativeQuery("SELECT * FROM vehicle WHERE YEAR = ?", Vehicle.class);
//
////        Query sql = entityManager.createNativeQuery("SELECT * FROM vehicle WHERE YEAR = ?", Vehicle.class);
////        sql.setParameter(1, year);
////        List<Vehicle> list = sql.getResultList();
////        return list;
//
////        Query sql = entityManager.createNativeQuery("SELECT id, brand, model, year FROM bike WHERE YEAR = ?");
////        sql.setParameter(1, year);
////        List<Object[]> list2 = sql.getResultList();
//
//        List<Vehicle> list = new ArrayList<>();
////        for (Object[] item: list2
////             ) {
////            Vehicle v = new Vehicle();
////            v.setId(((BigInteger) item[0]).longValue());
////            v.setBrand((String) item[1]);
////            v.setModel((String) item[2]);
////            v.setYear((Integer) item[3]);
////            list.add(v);
////        }
//        return list;
//    }

//    @Override
//    public List<Vehicle> findAllByYear(Integer year){
//        Query sql = entityManager.createNativeQuery(
//                "SELECT * FROM vehicle v " +
//                        "left join bike b on v.id = b.id  " +
//                        "left join car c on v.id = c.id " +
//                        "WHERE v.YEAR = ?", Vehicle.class);
//
//        sql.setParameter(1, year);
//        List<Vehicle> list = sql.getResultList();
//        return list;
//    }

    @Override
    public List<Vehicle> abobrinha(Integer year) {
        Query sql = entityManager.createNativeQuery(
                "SELECT * FROM vehicle v " +
                        "left join bike b on v.id = b.id  " +
                        "left join car c on v.id = c.id " +
                        "WHERE v.YEAR > ?", Vehicle.class);

        sql.setParameter(1, year);
        List<Vehicle> list = sql.getResultList();
        return list;
    }
}
