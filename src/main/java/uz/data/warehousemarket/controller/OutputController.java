package uz.data.warehousemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Output;
import uz.data.warehousemarket.payload.OutputDto;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.OutputService;
import java.util.List;

@RestController
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputController {

    OutputService outputService;
    @GetMapping
    public List<Output> getAll(){
        return outputService.getAll();
    }
    @GetMapping("/{id}")
    public Output getById(@PathVariable Integer id){
        return outputService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody OutputDto outputDto){
        return outputService.add(outputDto);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody OutputDto outputDto,@PathVariable Integer id){
        return outputService.update(outputDto,id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return outputService.deleteById(id);
    }

}
