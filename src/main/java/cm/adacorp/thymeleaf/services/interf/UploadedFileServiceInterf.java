package cm.adacorp.thymeleaf.services.interf;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadedFileServiceInterf {
    Map<String, String> saveFile(MultipartFile file);
}
