package uz.data.warehousemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.service.AttachmentContentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/attachmentcontent")
public class AttachmentContentController {

    @Autowired
    AttachmentContentService attachmentContentService;

    @GetMapping("/{id}")
    public void downloadAttachment(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        attachmentContentService.downloadAttachment(id,response);
    }

    @PostMapping
    public Result addAttachment(MultipartHttpServletRequest request) throws IOException {
        Result result = attachmentContentService.addFile(request);
        return result;
    }

}
