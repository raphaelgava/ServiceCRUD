package br.com.rd.ProjetoServico.Repository.contract;

import br.com.rd.ProjetoServico.Model.Entity.Bike;
import br.com.rd.ProjetoServico.Model.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>, VehicleRepositoryCustom {
    List<Vehicle> findAllByYear(Integer year);
    List<Vehicle> findAllByModel(String model); //findAll By {Column}
}
