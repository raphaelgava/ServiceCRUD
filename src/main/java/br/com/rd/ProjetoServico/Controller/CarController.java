package br.com.rd.ProjetoServico.Controller;

import br.com.rd.ProjetoServico.Model.DTO.CarDTO;
import br.com.rd.ProjetoServico.Service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="/cars")
@RestController
@RequestMapping(value="/cars")
public class CarController {
    @Autowired
    CarService carService;

    @ApiOperation(value="Create car data in data base")
    @PostMapping
    @ResponseBody
    public CarDTO create(@RequestBody CarDTO car){
        return carService.create(car);
    }

    @ApiOperation(value="Find all cars data in data base", response = CarDTO.class, responseContainer = "List")
    @GetMapping
    @ResponseBody
    public List<CarDTO> findAll(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public CarDTO findById(@PathVariable("id") Long id){
        return carService.findById(id);
    }

    @GetMapping("/findAllByYear")
//    @GetMapping("/findAllByYear/{year}")
    @ResponseBody
    public List<CarDTO> findAllByYear(@RequestParam("year") Integer year){
//    public List<CarDTO> findAllByYear(@PathVariable("year") Integer year){
        return carService.findAllByYear(year);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public CarDTO update(@PathVariable("id") Long id, @RequestBody CarDTO dto){
        return carService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        carService.deleteById(id);
    }
}
