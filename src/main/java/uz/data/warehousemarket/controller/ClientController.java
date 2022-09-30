package uz.data.warehousemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Client;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client get(@PathVariable Integer id){
        return clientService.getById(id);
    }

    @PostMapping
    public Result add(@RequestBody Client client){
        return clientService.add(client);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody Client client,@PathVariable Integer id){
        return clientService.update(client,id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return clientService.deleteById(id);
    }

}
