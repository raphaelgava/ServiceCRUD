package br.com.rd.ProjetoServico.Controller;

import br.com.rd.ProjetoServico.Model.DTO.MediaDTO;
import br.com.rd.ProjetoServico.Service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/medias")
public class MediaController {
    @Autowired
    MediaService mediaService;

    @PostMapping
    @ResponseBody
    public MediaDTO create(@RequestBody MediaDTO media){
        return mediaService.create(media);
    }

    @GetMapping
    @ResponseBody
    public List<MediaDTO> findAll(){
        return mediaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public MediaDTO findById(@PathVariable("id") Long id){
        return mediaService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public MediaDTO update(@PathVariable("id") Long id, @RequestBody MediaDTO dto){
        return mediaService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        mediaService.deleteById(id);
    }
}
