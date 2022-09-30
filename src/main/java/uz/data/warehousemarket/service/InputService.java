package uz.data.warehousemarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Currency;
import uz.data.warehousemarket.entity.Input;
import uz.data.warehousemarket.entity.Supplier;
import uz.data.warehousemarket.entity.Warehouse;
import uz.data.warehousemarket.payload.InputDto;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.CurrencyRepository;
import uz.data.warehousemarket.repository.InputRepository;
import uz.data.warehousemarket.repository.SupplierRepository;
import uz.data.warehousemarket.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InputService {

    InputRepository inputRepository;
    WarehouseRepository warehouseRepository;
    SupplierRepository supplierRepository;
    CurrencyRepository currencyRepository;

    public List<Input> getAll(){
        return inputRepository.findAll();
    }
    public Input get(Integer id){
        Optional<Input> byId = inputRepository.findById(id);
        return byId.orElse(null);
    }
    public Result add(InputDto inputDto){
        Optional<Warehouse> warehouseById = warehouseRepository.findById(inputDto.getWarehouseId());
        if(warehouseById.isEmpty()){
            return new Result("Warehouse not found",false);
        }
        Warehouse warehouse = warehouseById.get();
        Optional<Supplier> supplierRepositoryById = supplierRepository.findById(inputDto.getSupplierId());
        if(supplierRepositoryById.isEmpty()){
            return new Result("Supplier not found",false);
        }
        Supplier supplier = supplierRepositoryById.get();
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(inputDto.getCurrencyId());
        if(currencyRepositoryById.isEmpty()){
            return new Result("Currency not found",false);
        }
        Currency currency = currencyRepositoryById.get();
        Input input = new Input();
        input.setCode(UUID.randomUUID().toString());
        input.setTimestamp(inputDto.getTimestamp());
        input.setFactureNumber(input.getFactureNumber());
        input.setSupplier(supplier);
        input.setWarehouse(warehouse);
        input.setCurrency(currency);
        inputRepository.save(input);
        return new Result("Successfull saved",true);
    }
    public Result update(InputDto inputDto,Integer id){
        Optional<Warehouse> warehouseById = warehouseRepository.findById(inputDto.getWarehouseId());
        if(warehouseById.isEmpty()){
            return new Result("Warehouse not found",false);
        }
        Warehouse warehouse = warehouseById.get();
        Optional<Supplier> supplierRepositoryById = supplierRepository.findById(inputDto.getSupplierId());
        if(supplierRepositoryById.isEmpty()){
            return new Result("Supplier not found",false);
        }
        Supplier supplier = supplierRepositoryById.get();
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(inputDto.getCurrencyId());
        if(currencyRepositoryById.isEmpty()){
            return new Result("Currency not found",false);
        }
        Currency currency = currencyRepositoryById.get();

        Optional<Input> byId = inputRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Input not found",false);
        }
        Input input = byId.get();
        input.setTimestamp(inputDto.getTimestamp());
        input.setFactureNumber(input.getFactureNumber());
        input.setSupplier(supplier);
        input.setWarehouse(warehouse);
        input.setCurrency(currency);
        inputRepository.save(input);
        return new Result("Successfull saved",true);
    }
    public Result deleteById(Integer id){
        Optional<Input> byId = inputRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Input not found",false);
        }
        inputRepository.deleteById(id);
        return new Result("Successfull deleted",true);
    }
}
