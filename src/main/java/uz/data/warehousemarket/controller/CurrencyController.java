package uz.data.warehousemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Currency;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.CurrencyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {

    final CurrencyService currencyService;

    @GetMapping
    public List<Currency> getAll(){
        return currencyService.getAll();
    }
    @GetMapping("/{id}")
    public Currency getById(@PathVariable Integer id){
        return currencyService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody Currency currency){
        return currencyService.add(currency);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody Currency currency,@PathVariable Integer id){
        return currencyService.update(currency,id);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        return currencyService.deleteById(id);
    }

}
