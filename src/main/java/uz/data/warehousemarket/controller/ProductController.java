package uz.data.warehousemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Product;
import uz.data.warehousemarket.payload.ProductDto;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public  Product getById(@PathVariable Integer id){
        return productService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody ProductDto productDto){
        return productService.update(id,productDto);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return productService.delete(id);
    }

}
