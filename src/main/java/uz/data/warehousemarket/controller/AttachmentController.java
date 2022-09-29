package uz.data.warehousemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.data.warehousemarket.entity.Attachment;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.AttachmentService;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @GetMapping("/{id}")
    public Attachment getAttachmentById(@PathVariable Integer id){
        return attachmentService.getAttachmentById(id);
    }

    @PostMapping
    public Result addAttachment(@RequestBody Attachment attachment){
        return attachmentService.addAttachment(attachment);
    }


}
