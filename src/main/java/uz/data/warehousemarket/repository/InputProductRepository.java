package uz.data.warehousemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehousemarket.entity.InputProduct;

import java.util.List;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {

    List<InputProduct> getInputProductsByInput_Id(Integer id);

}
