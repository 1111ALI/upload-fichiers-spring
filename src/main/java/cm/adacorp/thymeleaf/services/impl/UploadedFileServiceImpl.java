package cm.adacorp.thymeleaf.services.impl;

import cm.adacorp.thymeleaf.entity.UploadedFile;
import cm.adacorp.thymeleaf.repository.UploadedFileRepository;
import cm.adacorp.thymeleaf.services.interf.UploadedFileServiceInterf;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UploadedFileServiceImpl implements UploadedFileServiceInterf {

    private final UploadedFileRepository uploadedFileRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    private Path route;

//    private final Path route = Paths.get("uploads");

    @PostConstruct
    public void init() {
        this.route = Paths.get(uploadDir);
        try{
            Files.createDirectory(route);
        }catch (IOException e){
            throw new RuntimeException("Echec d'initialization du repertoire de base");
        }
    }

    @Override
    public Map<String, String> saveFile(MultipartFile file) {

        Map<String, String> reponse = new HashMap<>();

        reponse.put("type","uploading...");

        try{

            Files.copy(file.getInputStream(), this.route.resolve(file.getOriginalFilename()));

            UploadedFile uploadedFile = new UploadedFile();
            uploadedFile.setFileName(file.getOriginalFilename());
            uploadedFile.setFileType(file.getContentType());
            uploadedFileRepository.save(uploadedFile);

            reponse.put("message","Upload success !");
            reponse.put("file",file.getOriginalFilename());

        }catch (Exception e){
            reponse.put("message","Error uploading file : "+ e.getMessage());
        }

        return reponse;
    }
}
