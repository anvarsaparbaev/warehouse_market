package uz.data.warehousemarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Warehouse;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.WarehouseRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    final WarehouseRepository warehouseRepository;

    public List<Warehouse> getAll(){
        return warehouseRepository.findAll();
    }

    public Warehouse getById(Integer id){
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        return byId.orElse(null);
    }
    public Result delete(Integer id){
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Warehouse not found",false);
        }
        warehouseRepository.deleteById(id);
        return new Result("Succesfull deleted",true);
    }

    public Result update(Warehouse warehouse,Integer id){
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Warehouse not found",false);
        }
        Warehouse updating = byId.get();
        updating.setName(warehouse.getName());
        updating.setActive(warehouse.isActive());
        warehouseRepository.save(updating);
        return new Result("Successfull updated",true);
    }

    public Result add(Warehouse warehouse){
        warehouseRepository.save(warehouse);
        return new Result("Successfull saved",true);
    }

}
