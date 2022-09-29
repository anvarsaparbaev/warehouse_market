package uz.data.warehousemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehousemarket.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByCode(String code);

}
