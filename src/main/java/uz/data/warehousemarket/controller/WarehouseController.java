package uz.data.warehousemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Warehouse;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {

    final WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getAll(){
        return warehouseService.getAll();
    }
    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable Integer id){
        return warehouseService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody Warehouse warehouse){
        return warehouseService.add(warehouse);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody Warehouse warehouse,@PathVariable Integer id){
        return warehouseService.update(warehouse,id);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        return warehouseService.delete(id);
    }

}
