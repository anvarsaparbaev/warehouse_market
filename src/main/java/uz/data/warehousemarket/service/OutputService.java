package uz.data.warehousemarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Client;
import uz.data.warehousemarket.entity.Currency;
import uz.data.warehousemarket.entity.Output;
import uz.data.warehousemarket.entity.Warehouse;
import uz.data.warehousemarket.payload.OutputDto;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.ClientRepository;
import uz.data.warehousemarket.repository.CurrencyRepository;
import uz.data.warehousemarket.repository.OutputRepository;
import uz.data.warehousemarket.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OutputService {
    OutputRepository outputRepository;
    WarehouseRepository warehouseRepository;
    CurrencyRepository currencyRepository;
    ClientRepository clientRepository;

    public List<Output> getAll(){
        return outputRepository.findAll();
    }

    public Output getById(Integer id){
        Optional<Output> byId = outputRepository.findById(id);
        return byId.orElse(null);
    }

    public Result add(OutputDto outputDto){
        Optional<Warehouse> warehouseRepositoryById = warehouseRepository.findById(outputDto.getWarehouseId());
        if(warehouseRepositoryById.isEmpty()){
            return new Result("Warehouse not found",false);
        }
        Warehouse warehouse = warehouseRepositoryById.get();
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(outputDto.getCurrencyId());
        if(currencyRepositoryById.isEmpty()){
            return new Result("Currency not found",false);
        }
        Currency currency = currencyRepositoryById.get();
        boolean b = clientRepository.existsByPhoneNumber(outputDto.getClientPhoneNumber());
        if(b){
            return new Result("Client phone number already exist",false);
        }
        Client client = new Client(null, outputDto.getClientName(), outputDto.getClientPhoneNumber());
        Output output = new Output();
        output.setClient(client);
        output.setDate(outputDto.getTimestamp());
        output.setCurrency(currency);
        output.setWarehouse(warehouse);
        output.setFactureNumber(output.getFactureNumber());
        output.setCode(UUID.randomUUID().toString());
        outputRepository.save(output);
        return new Result("Successfull saved",true);

    }

    public Result update(OutputDto outputDto,Integer id){
        Optional<Warehouse> warehouseRepositoryById = warehouseRepository.findById(outputDto.getWarehouseId());
        if(warehouseRepositoryById.isEmpty()){
            return new Result("Warehouse not found",false);
        }
        Warehouse warehouse = warehouseRepositoryById.get();
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(outputDto.getCurrencyId());
        if(currencyRepositoryById.isEmpty()){
            return new Result("Currency not found",false);
        }
        Currency currency = currencyRepositoryById.get();
        boolean b = clientRepository.existsByPhoneNumber(outputDto.getClientPhoneNumber());
        if(b){
            return new Result("Client phone number already exist",false);
        }
        Client client = new Client(null, outputDto.getClientName(), outputDto.getClientPhoneNumber());
        Optional<Output> byId = outputRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Output not found",false);
        }
        Output output = byId.get();
        output.setClient(client);
        output.setDate(outputDto.getTimestamp());
        output.setCurrency(currency);
        output.setWarehouse(warehouse);
        output.setFactureNumber(output.getFactureNumber());
        output.setCode(UUID.randomUUID().toString());
        outputRepository.save(output);
        return new Result("Successfull updated",true);
    }
    public Result deleteById(Integer id){
        Optional<Output> byId = outputRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Output not found",false);
        }
        outputRepository.deleteById(id);
        return new Result("Successfull deleted",true);
    }

}
