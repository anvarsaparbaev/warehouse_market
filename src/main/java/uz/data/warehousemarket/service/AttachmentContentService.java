package uz.data.warehousemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.data.warehousemarket.entity.Attachment;
import uz.data.warehousemarket.entity.AttachmentContent;
import uz.data.warehousemarket.payload.Result;
import uz.data.warehousemarket.repository.AttachmentContentRepository;
import uz.data.warehousemarket.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmentContentService {

    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @Autowired
    AttachmentRepository attachmentRepository;


    public void downloadAttachment(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if(byId.isPresent()){
            Attachment attachment = byId.get();
            Optional<AttachmentContent> attachmentContentByAttachment_id = attachmentContentRepository.getAttachmentContentByAttachment_Id(attachment.getId());
            if(attachmentContentByAttachment_id.isPresent()){
                AttachmentContent attachmentContent = attachmentContentByAttachment_id.get();
                response.setHeader("Content-Disposiotion",
                        "attachment; filename=\""+attachment.getName()+"\"");
                response.setContentType(attachment.getContentType());
                FileCopyUtils.copy(attachmentContent.getBytes(),response.getOutputStream());
            }

        }
    }

    public Result addFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if(file.isEmpty()){
            return new Result("File not found",false);
        }
        String originalFilename = file.getOriginalFilename();
        String contentType = file.getContentType();
        long size = file.getSize();
        Attachment save = attachmentRepository.save(new Attachment(null, originalFilename, size, contentType));
        byte[] bytes = file.getBytes();
        attachmentContentRepository.save(new AttachmentContent(null,bytes,save));
        return new Result("Successfull saved",true);
    }




}
