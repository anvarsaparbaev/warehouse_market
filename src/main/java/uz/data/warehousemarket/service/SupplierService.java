package uz.data.warehousemarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Supplier;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.SupplierRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService{

    final SupplierRepository supplierRepository;

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }
    public Supplier getById(Integer id){
        Optional<Supplier> byId = supplierRepository.findById(id);
        return byId.orElse(null);
    }
    public Result add(Supplier supplier){
        boolean b = supplierRepository.existsByPhoneNumber(supplier.getName());
        if(b){
            return new Result("This phone number already exist",false);
        }
        supplierRepository.save(supplier);
        return new Result("Successfull saved",true);
    }
    public Result update(Supplier supplier,Integer id){
        Optional<Supplier> byId = supplierRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Supplier not found",false);
        }
        boolean b = supplierRepository.existsByPhoneNumber(supplier.getName());
        if(b){
            return new Result("This phone number already exist",false);
        }
        Supplier updating = byId.get();
        updating.setName(supplier.getName());
        updating.setPhoneNumber(supplier.getPhoneNumber());
        updating.setActive(supplier.isActive());
        supplierRepository.save(updating);
        return new Result("Successfull updated",true);
    }
    public Result deleteById(Integer id){
        Optional<Supplier> byId = supplierRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Supplier not found",false);
        }
        supplierRepository.deleteById(id);
        return new Result("Successfull deleted",true);
    }

}
