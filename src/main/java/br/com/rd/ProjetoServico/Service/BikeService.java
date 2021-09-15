package br.com.rd.ProjetoServico.Service;

import br.com.rd.ProjetoServico.Model.DTO.BikeDTO;
import br.com.rd.ProjetoServico.Model.DTO.CarDTO;
import br.com.rd.ProjetoServico.Model.Entity.Bike;
import br.com.rd.ProjetoServico.Model.Entity.Car;
import br.com.rd.ProjetoServico.Model.Entity.Vehicle;
import br.com.rd.ProjetoServico.Repository.contract.BikeRepository;
import br.com.rd.ProjetoServico.Repository.contract.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    BikeRepository bikeRepository;

    public BikeDTO create(BikeDTO bike){
        Bike model = dtoToBusiness(bike);
        model = bikeRepository.save(model);
        return businessToDto(model);
    }

    public List<BikeDTO> findAll(){
        List<Bike> responseList = bikeRepository.findAll();
        return getBikeDTOS(responseList);
//        return null;
    }

    public BikeDTO findById(Long id){
        Optional<Bike> bike = bikeRepository.findById(id);
        BikeDTO response = null;

        if (bike.isPresent()){
            //if (bike.get() instanceof Bike)
            //    response = businessToDto((Bike) bike.get());
            response = businessToDto(bike.get());
        }

        return response;
    }

//    private List<BikeDTO> getBikeDTOS(List<Vehicle> list) {
//        List<BikeDTO> dtoList = new ArrayList<>();
//        for (Vehicle c : list) {
//            if (c instanceof Bike)
//                dtoList.add(businessToDto((Bike) c));
//        }
//        return dtoList;
//    }

    private List<BikeDTO> getBikeDTOS(List<Bike> list) {
        List<BikeDTO> dtoList = new ArrayList<>();
        for (Bike b : list) {
            dtoList.add(businessToDto(b));
        }
        return dtoList;
    }

    public List<BikeDTO> findAllByYear(Integer year){
//        List<Vehicle> bikeList = bikeRepository.findAllByYear(year);
//        List<Bike> anotherBikeList = new ArrayList(bikeList);
//        return getBikeDTOS(anotherBikeList);

        List<Bike> anotherBikeList = bikeRepository.findAllByYear(year);
        return getBikeDTOS(anotherBikeList);
    }

    public List<BikeDTO> findAllByYearOrdered(Integer year){
        List<Bike> anotherBikeList = bikeRepository.findAllByYearOrderByModelAsc(year);;
        return getBikeDTOS(anotherBikeList);
    }

    public BikeDTO updateById(Long id, BikeDTO dto) {
//        Optional<Vehicle> updating = bikeRepository.findById(id); //Vai retornar o objeto relativo com o tipo que foi cadastrado
//        if (updating.isPresent()) {
//            if (updating.get() instanceof Vehicle)
//                System.out.println(updating.get().getModel());
//            if (updating.get() instanceof Bike) {
//                Bike c = (Bike) updating.get();
////        Vehicle updating = bikeRepository.getById(id); //Vai retornar exatamente o objeto que esta na interface
////        if (updating instanceof Vehicle)
////            System.out.println(updating.getModel());
////        if (updating instanceof Bike) {
//            Bike c = (Bike) updating;
        Optional<Bike> updating = bikeRepository.findById(id);
        if (updating.isPresent()) {
            Bike b = updating.get();
            b.setId(id);
            if (dto.getBrand() != null) {
                b.setBrand(dto.getBrand());
            }
            if (dto.getModel() != null) {
                b.setModel(dto.getModel());
            }
            if (dto.getYear() != null) {
                b.setYear(dto.getYear());
            }
            if (dto.getCubicCapacity() != null) {
                b.setCubicCapacity(dto.getCubicCapacity());
            }
            bikeRepository.save(b);
            return this.businessToDto(b);
        }
        return null;
    }

    public void deleteById(Long id) {
//        if (bikeRepository.existsById(id)){
//            Optional<Vehicle> d = bikeRepository.findById(id); //Vai retornar o objeto relativo com o tipo que foi cadastrado
//            if (d.isPresent())
//            //Vehicle d = bikeRepository.getById(id);//Vai retornar exatamente o objeto que esta na interface
//                if (d.get() instanceof Bike)
//                    bikeRepository.deleteById(id);
//        }
        if (bikeRepository.existsById(id)){
            Optional<Bike> d = bikeRepository.findById(id); //Vai retornar o objeto relativo com o tipo que foi cadastrado
            if (d.isPresent())
                bikeRepository.deleteById(id);
        }
    }

    private BikeDTO businessToDto(Bike bike){
        BikeDTO v = new BikeDTO();
        v.setId(bike.getId());
        v.setBrand(bike.getBrand());
        v.setModel(bike.getModel());
        v.setYear(bike.getYear());
        v.setCubicCapacity(bike.getCubicCapacity());
        return v;
    }

    private Bike dtoToBusiness(BikeDTO bikeDTO){
        Bike v = new Bike();
        v.setBrand(bikeDTO.getBrand());
        v.setModel(bikeDTO.getModel());
        v.setYear(bikeDTO.getYear());
        v.setCubicCapacity(bikeDTO.getCubicCapacity());
        return v;
    }

}
