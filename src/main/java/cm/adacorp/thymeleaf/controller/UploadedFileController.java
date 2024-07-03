package cm.adacorp.thymeleaf.controller;

import cm.adacorp.thymeleaf.services.interf.UploadedFileServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UploadedFileController {
    private final UploadedFileServiceInterf uploadedFileServiceInterf;

    public Map<String, String> saveFile(MultipartFile file){
        return uploadedFileServiceInterf.saveFile(file);
    }
}
