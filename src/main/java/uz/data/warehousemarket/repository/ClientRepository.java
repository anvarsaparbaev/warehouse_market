package uz.data.warehousemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehousemarket.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);

}
