package br.com.rd.ProjetoServico.Repository.contract;

import br.com.rd.ProjetoServico.Model.Entity.Bike;
import br.com.rd.ProjetoServico.Model.Entity.Car;
import br.com.rd.ProjetoServico.Model.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long>{
    List<Bike> findAllByYear(Integer year);
    List<Bike> findAllByYearOrderByModelAsc(Integer year);
}
