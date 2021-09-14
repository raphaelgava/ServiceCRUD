package br.com.rd.ProjetoServico.Controller;

import br.com.rd.ProjetoServico.Model.DTO.BikeDTO;
import br.com.rd.ProjetoServico.Service.BikeService;
import br.com.rd.ProjetoServico.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/bikes")
public class BikeController {
    @Autowired
    BikeService bikeService;

    @PostMapping
    @ResponseBody
    public BikeDTO create(@RequestBody BikeDTO car){
        return bikeService.create(car);
    }

    @GetMapping
    @ResponseBody
    public List<BikeDTO> findAll(){
        return bikeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public BikeDTO findById(@PathVariable("id") Long id){
        return bikeService.findById(id);
    }

    @GetMapping("/findAllByYear")
//    @GetMapping("/findAllByYear/{year}")
    @ResponseBody
    public List<BikeDTO> findAllByYear(@RequestParam("year") Integer year){
//    public List<BikeDTO> findAllByYear(@PathVariable("year") Integer year){
        return bikeService.findAllByYear(year);
    }

    @GetMapping("/findAllByYearOrdered")
    @ResponseBody
    public List<BikeDTO> findAllByYearOrdered(@RequestParam("year") Integer year){
        return bikeService.findAllByYearOrdered(year);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public BikeDTO update(@PathVariable("id") Long id, @RequestBody BikeDTO dto){
        return bikeService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        bikeService.deleteById(id);
    }
}
