package br.com.rd.ProjetoServico.Service;

import br.com.rd.ProjetoServico.Model.DTO.CarDTO;
import br.com.rd.ProjetoServico.Model.DTO.MediaDTO;
import br.com.rd.ProjetoServico.Model.Entity.Car;
import br.com.rd.ProjetoServico.Model.Entity.Car;
import br.com.rd.ProjetoServico.Model.Entity.Media;
import br.com.rd.ProjetoServico.Model.Entity.Vehicle;
import br.com.rd.ProjetoServico.Repository.contract.CarRepository;
import br.com.rd.ProjetoServico.Repository.contract.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public CarDTO create(CarDTO car){
        Car model = dtoToBusiness(car);
        model = carRepository.save(model);
        return businessToDto(model);
    }

    public List<CarDTO> findAll(){
        List<Car> responseList = carRepository.findAll();
        return getCarDTOS(responseList);
    }

    public CarDTO findById(Long id){
        Optional<Car> car = carRepository.findById(id);
        CarDTO response = null;

        if (car.isPresent()){
            response = businessToDto(car.get());
        }

        return response;
    }

    private List<CarDTO> getCarDTOS(List<Car> list) {
        List<CarDTO> dtoList = new ArrayList<>();
        for (Car c : list) {
            dtoList.add(businessToDto( c));
        }
        return dtoList;
    }

    public List<CarDTO> findAllByYear(Integer year){
//        List<Vehicle> carList = carRepository.findAllByYear(year);
//        List<Car> anotherCarList = new ArrayList(carList);
//        return getCarDTOS(anotherCarList);

        List<Car> anotherCarList = carRepository.findAllByYear(year);
        return getCarDTOS(anotherCarList);
    }

    public CarDTO updateById(Long id, CarDTO dto) {
        Optional<Car> find = carRepository.findById(id); //Vai retornar o objeto relativo com o tipo que foi cadastrado
        if (find.isPresent()) {
            if (find.get() instanceof Car) {
                Car c = find.get();
                //Car c = carRepository.getById(id); // TODO: 31/08/2021 - verificar razão do get falhar!
                //if (c instanceof Car) {
                c.setId(id);
                if (dto.getBrand() != null) {
                    c.setBrand(dto.getBrand());
                }
                if (dto.getModel() != null) {
                    c.setModel(dto.getModel());
                }
                if (dto.getYear() != null) {
                    c.setYear(dto.getYear());
                }
                if (dto.getTurbine() != null) {
                    c.setTurbine(dto.getTurbine());
                }
                if (dto.getMedia().getId() != null) {
                    c.setMedia(mediaDTOToMedia(dto));
                }
                carRepository.save(c);
                return this.businessToDto(c);
            }
        }
        return null;
    }

    private Media mediaDTOToMedia(CarDTO dto) {
        Media media = new Media();
        media.setId(dto.getMedia().getId());
        media.setDescription(dto.getMedia().getDescription());
        media.setTouch(dto.getMedia().getTouch());
        return media;
    }

    public void deleteById(Long id) {
        if (carRepository.existsById(id)){
            carRepository.deleteById(id);
        }
    }

    private CarDTO businessToDto(Car car){
        CarDTO v = new CarDTO();
        v.setId(car.getId());
        v.setBrand(car.getBrand());
        v.setModel(car.getModel());
        v.setYear(car.getYear());
        v.setTurbine(car.getTurbine());
        if (car.getMedia() != null){
            MediaDTO media = new MediaDTO();
            media.setId(car.getMedia().getId());
            media.setDescription(car.getMedia().getDescription());
            media.setTouch(car.getMedia().getTouch());
            v.setMedia(media);
        }

        return v;
    }

    private Car dtoToBusiness(CarDTO carDTO){
        Car v = new Car();
        v.setBrand(carDTO.getBrand());
        v.setModel(carDTO.getModel());
        v.setYear(carDTO.getYear());
        v.setTurbine(carDTO.getTurbine());
        Media media = new Media();
        if (carDTO.getMedia().getId() != null) {
            media.setId(carDTO.getMedia().getId());
        }else{
            media.setDescription(carDTO.getMedia().getDescription());
            media.setTouch(carDTO.getMedia().getTouch());
        }
        v.setMedia(media);
//        v.setMedia(mediaDTOToMedia(carDTO));
        return v;
    }

}
