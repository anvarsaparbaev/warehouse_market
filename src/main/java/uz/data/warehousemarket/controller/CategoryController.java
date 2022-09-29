package uz.data.warehousemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Category;
import uz.data.warehousemarket.payload.CategoryDto;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.CategoryService;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    final
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id){
        return categoryService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody CategoryDto categoryDto){
        return categoryService.add(categoryDto);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody CategoryDto categoryDto,@PathVariable Integer id){
        return categoryService.update(categoryDto,id);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        return categoryService.deleteById(id);
    }

}
