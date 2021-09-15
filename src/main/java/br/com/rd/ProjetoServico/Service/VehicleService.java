package br.com.rd.ProjetoServico.Service;

import br.com.rd.ProjetoServico.Model.DTO.CarDTO;
import br.com.rd.ProjetoServico.Model.DTO.VehicleDTO;
import br.com.rd.ProjetoServico.Model.Entity.Car;
import br.com.rd.ProjetoServico.Model.Entity.Vehicle;
import br.com.rd.ProjetoServico.Repository.contract.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
//    public static List<Vehicle> list = new ArrayList<>();
    @Autowired
    VehicleRepository vehicleRepository;

    public VehicleDTO create(VehicleDTO vehicle){
//        vehicle.setId(new Long(list.size() + 1));
//        this.list.add(vehicle);
//        return vehicle;

//        Vehicle model = dtoToBusiness(vehicle);
//        model.setId(new Long(list.size() + 1));
//        this.list.add(model);
//        return businessToDto(model);

        Vehicle model = dtoToBusiness(vehicle);
        model = vehicleRepository.save(model);
        return businessToDto(model);
    }

    public List<VehicleDTO> findAll(){
//        return this.list;
        List<Vehicle> responseList = vehicleRepository.findAll();
        return getVehicleDTOS(responseList);
    }

    public VehicleDTO findById(Long id){
//        return list.get(id.intValue() - 1);
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        VehicleDTO response = null;

        if (vehicle.isPresent()){
            response = businessToDto(vehicle.get());
        }

        return response;
    }

    private List<VehicleDTO> getVehicleDTOS(List<Vehicle> list) {
        List<VehicleDTO> dtoList = new ArrayList<>();
        for (Vehicle v : list) {
            dtoList.add(businessToDto(v));
        }
        return dtoList;
    }

    public List<VehicleDTO> findAllByYear(Integer year){
        List<Vehicle> vehicleList = vehicleRepository.findAllByYear(year);
        return getVehicleDTOS(vehicleList);
    }

    public List<VehicleDTO> findAllByModel(String model){
        List<Vehicle> vehicleList = vehicleRepository.findAllByModel(model);
        return getVehicleDTOS(vehicleList);
    }

    public List<VehicleDTO> findAllFromYear(Integer year){
        List<Vehicle> vehicleList = vehicleRepository.abobrinha(year);
        return getVehicleDTOS(vehicleList);
    }

    public VehicleDTO updateById(Long id, VehicleDTO dto) {
        Vehicle updating = vehicleRepository.getById(id);
        updating.setId(id);
        if (dto.getBrand() != null) {
            updating.setBrand(dto.getBrand());
        }
        if (dto.getModel() != null){
            updating.setModel(dto.getModel());
        }
        if (dto.getYear() != null){
            updating.setYear(dto.getYear());
        }

        vehicleRepository.save(updating);
        return this.businessToDto(updating);
    }

    public void deleteById(Long id) {
        if (vehicleRepository.existsById(id)){
            vehicleRepository.deleteById(id);
        }
    }

    private VehicleDTO businessToDto(Vehicle vehicle){
        VehicleDTO v = new VehicleDTO();
        v.setId(vehicle.getId());
        v.setBrand(vehicle.getBrand());
        v.setModel(vehicle.getModel());
        v.setYear(vehicle.getYear());
        return v;
    }

    private Vehicle dtoToBusiness(VehicleDTO vehicleDTO){
        Vehicle v = new Vehicle();
        v.setBrand(vehicleDTO.getBrand());
        v.setModel(vehicleDTO.getModel());
        v.setYear(vehicleDTO.getYear());
        return v;
    }

}
