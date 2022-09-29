package uz.data.warehousemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.data.warehousemarket.entity.Attachment;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.AttachmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    public Result addAttachment(Attachment attachment){
        attachmentRepository.save(attachment);
        return new Result("Successfull saved",true);
    }

    public Attachment getAttachmentById(Integer id){
        Optional<Attachment> byId = attachmentRepository.findById(id);
        return byId.orElse(null);
    }


}
