package uz.data.warehousemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehousemarket.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
