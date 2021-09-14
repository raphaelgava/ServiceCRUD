package br.com.rd.ProjetoServico.Controller;

import br.com.rd.ProjetoServico.Model.DTO.CarDTO;
import br.com.rd.ProjetoServico.Model.DTO.VehicleDTO;
import br.com.rd.ProjetoServico.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/vehicles")
public class VehicleController {

//    public static List<Vehicle> list = new ArrayList<>();

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    @ResponseBody
    public VehicleDTO create(@RequestBody VehicleDTO vehicle){
        return vehicleService.create(vehicle);
//        vehicle.setId(new Long(list.size() + 1));
//        this.list.add(vehicle);
//        return vehicle;
    }

    @GetMapping
    @ResponseBody
    public List<VehicleDTO> findAll(){
//        return this.list;

        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VehicleDTO findById(@PathVariable("id") Long id){
//        return list.get(id.intValue() - 1);

        return vehicleService.findById(id);
    }

    @GetMapping("/findAllByYear")
//    @GetMapping("/findAllByYear/{year}")
    @ResponseBody
    public List<VehicleDTO> findAllByYear(@RequestParam("year") Integer year){
//    public List<VehicleDTO> findAllByYear(@PathVariable("year") Integer year){
        return vehicleService.findAllByYear(year);
    }

    @GetMapping("/findAllByModel")
    @ResponseBody
    public List<VehicleDTO> findAllByYear(@RequestParam("model") String model){
        return vehicleService.findAllByModel(model);
    }

    @GetMapping("/findAllFromYear")
    @ResponseBody
    public List<VehicleDTO> findAllFromYear(@RequestParam("year") Integer year){
        return vehicleService.findAllFromYear(year);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public VehicleDTO update(@PathVariable("id") Long id, @RequestBody VehicleDTO dto){
        return vehicleService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        vehicleService.deleteById(id);
    }
}
