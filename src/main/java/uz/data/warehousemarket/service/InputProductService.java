package uz.data.warehousemarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Input;
import uz.data.warehousemarket.entity.InputProduct;
import uz.data.warehousemarket.entity.Product;
import uz.data.warehousemarket.payload.InputProductDto;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.InputProductRepository;
import uz.data.warehousemarket.repository.InputRepository;
import uz.data.warehousemarket.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InputProductService {
    InputProductRepository inputProductRepository;
    ProductRepository productRepository;
    InputRepository inputRepository;

    //Hamme kirgen tovarlardi aliw
    public List<InputProduct> getAll(){
        return inputProductRepository.findAll();
    }
    //Kirgen tovarlardi Id arqali aliw
    public InputProduct getById(Integer id){
        Optional<InputProduct> byId = inputProductRepository.findById(id);
        return byId.orElse(null);
    }
    public List<InputProduct> getByInputId(Integer inputId){
        return inputProductRepository.getInputProductsByInput_Id(inputId);
    }
    public Result add(InputProductDto inputProductDto){
        Optional<Product> productRepositoryById = productRepository.findById(inputProductDto.getProductId());
        if(productRepositoryById.isEmpty()){
            return new Result("Product not found",false);
        }
        Product product = productRepositoryById.get();
        Optional<Input> inputRepositoryById = inputRepository.findById(inputProductDto.getInputId());
        if(inputRepositoryById.isEmpty()){
            return new Result("Input not found",false);
        }
        Input input = inputRepositoryById.get();
        InputProduct inputProduct = new InputProduct();
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setInput(input);
        inputProduct.setProduct(product);
        inputProduct.setExpireDate(inputProductDto.getDate());
        inputProductRepository.save(inputProduct);
        return new Result("Successfull saved",true);
    }
    public Result update(InputProductDto inputProductDto,Integer id){
        Optional<Product> productRepositoryById = productRepository.findById(inputProductDto.getProductId());
        if(productRepositoryById.isEmpty()){
            return new Result("Product not found",false);
        }
        Product product = productRepositoryById.get();
        Optional<Input> inputRepositoryById = inputRepository.findById(inputProductDto.getInputId());
        if(inputRepositoryById.isEmpty()){
            return new Result("Input not found",false);
        }
        Input input = inputRepositoryById.get();
        Optional<InputProduct> byId = inputProductRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Input product not found",false);
        }
        InputProduct inputProduct = byId.get();
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setInput(input);
        inputProduct.setProduct(product);
        inputProduct.setExpireDate(inputProductDto.getDate());
        inputProductRepository.save(inputProduct);
        return new Result("Successfull saved",true);
    }
    public Result deleteById(Integer id){
        Optional<InputProduct> byId = inputProductRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Input not found",false);
        }
        inputProductRepository.deleteById(id);
        return new Result("Successfull deleted",true);
    }
}
