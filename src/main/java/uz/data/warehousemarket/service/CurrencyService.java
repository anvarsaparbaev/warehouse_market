package uz.data.warehousemarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Currency;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    final CurrencyRepository currencyRepository;

    public List<Currency> getAll(){
        return currencyRepository.findAll();
    }
    public Currency getById(Integer id){
        Optional<Currency> byId = currencyRepository.findById(id);
        return byId.orElse(null);
    }
    public Result add(Currency currency){
        if(currencyRepository.existsByName(currency.getName())){
            return new Result("This currency already exist",false);
        }
        currencyRepository.save(currency);
        return new Result("Successfull saved",true);
    }
    public Result update(Currency currency,Integer id){
        Optional<Currency> byId = currencyRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Currency not found",false);
        }
        if(currencyRepository.existsByName(currency.getName())){
            return new Result("This currency already exist",false);
        }
        Currency updating = byId.get();
        updating.setName(currency.getName());
        updating.setActive(currency.isActive());
        currencyRepository.save(updating);
        return new Result("Successfull updated",true);
    }
    public Result deleteById(Integer id){
        Optional<Currency> byId = currencyRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Currency not found",false);
        }
        currencyRepository.deleteById(id);
        return new Result("Successfull deleted",true);
    }

}
