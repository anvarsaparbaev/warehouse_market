package uz.data.warehousemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Supplier;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.SupplierService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {

    final SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAll(){
        return supplierService.getAll();
    }
    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Integer id){
        return supplierService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody Supplier supplier){
        return supplierService.add(supplier);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Supplier supplier){
        return supplierService.update(supplier, id);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        return supplierService.deleteById(id);
    }

}
