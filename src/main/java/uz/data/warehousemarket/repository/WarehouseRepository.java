package uz.data.warehousemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehousemarket.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
}
