package uz.data.warehousemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Input;
import uz.data.warehousemarket.payload.InputDto;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.InputService;

import java.util.List;

@RestController
@RequestMapping("/input")
@RequiredArgsConstructor
public class InputController {

    InputService inputService;
    @GetMapping
    public List<Input> getAll(){
        return inputService.getAll();
    }
    @GetMapping("/{id}")
    public Input get(@PathVariable Integer id){
        return inputService.get(id);
    }
    @PostMapping
    public Result add(@RequestBody InputDto input){
        return inputService.add(input);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody InputDto inputDto,@PathVariable Integer id){
        return inputService.update(inputDto,id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return inputService.deleteById(id);
    }
}
