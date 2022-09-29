package uz.data.warehousemarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Category;
import uz.data.warehousemarket.payload.CategoryDto;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    final
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public Category getById(Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.orElse(null);
    }
    public Result deleteById(Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Category not found",false);
        }
        categoryRepository.deleteById(id);
        return new Result("Successfull deleted",true);
    }
    public Result add(CategoryDto categoryDto){
        Category parentCategory = null;
        if(categoryDto.getCategoryId()!=null){
            Optional<Category> byId = categoryRepository.findById(categoryDto.getCategoryId());
            if(byId.isEmpty()){
                return new Result("Parent Category not found",false);
            }
            parentCategory = byId.get();
        }
        Category category = new Category();
        category.setName(categoryDto.getCategoryName());
        category.setActive(categoryDto.isActive());
        category.setCategory(parentCategory);
        categoryRepository.save(category);
        return new Result("Successfull saved",true);
    }
    public Result update(CategoryDto categoryDto,Integer id){
        Optional<Category> categoryById = categoryRepository.findById(id);
        if(categoryById.isEmpty()){
            return new Result("Category not found",false);
        }
        Category parentCategory = null;
        if(categoryDto.getCategoryId()!=null){
            Optional<Category> byId = categoryRepository.findById(categoryDto.getCategoryId());
            if(byId.isEmpty()){
                return new Result("Parent Category not found",false);
            }
            parentCategory = byId.get();
        }
        Category updating = categoryById.get();
        updating.setName(categoryDto.getCategoryName());
        updating.setActive(categoryDto.isActive());
        updating.setCategory(parentCategory);
        categoryRepository.save(updating);
        return new Result("Successfull updated",true);
    }

}
