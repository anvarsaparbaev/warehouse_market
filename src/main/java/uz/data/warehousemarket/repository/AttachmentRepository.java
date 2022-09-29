package uz.data.warehousemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehousemarket.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
