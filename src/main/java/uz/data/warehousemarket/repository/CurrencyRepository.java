package uz.data.warehousemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehousemarket.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

    boolean existsByName(String name);

}
