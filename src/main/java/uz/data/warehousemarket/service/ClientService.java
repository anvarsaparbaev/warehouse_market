package uz.data.warehousemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Client;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client getById(Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        return byId.orElse(null);
    }

    public Result add(Client client){
        if(clientRepository.existsByPhoneNumber(client.getPhoneNumber())){
            return new Result("Phone number already exist",false);
        }
        clientRepository.save(client);
        return new Result("Successfull saved",true);
    }

    public Result update(Client client,Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Client not found",false);
        }
        if(clientRepository.existsByPhoneNumber(client.getPhoneNumber())){
            return new Result("Phone number already exist",false);
        }
        Client updating = byId.get();
        updating.setName(client.getName());
        updating.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(updating);
        return new Result("Successfull updated",true);
    }
    public Result deleteById(Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        if(byId.isEmpty()){
            return new Result("Client not found",false);
        }
        clientRepository.deleteById(id);
        return new Result("Successfull deleted",true);
    }

}
