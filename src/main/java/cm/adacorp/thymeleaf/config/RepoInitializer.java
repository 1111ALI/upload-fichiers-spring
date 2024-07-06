//package cm.adacorp.thymeleaf.config;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Configuration
//@RequiredArgsConstructor
//public class RepoInitializer {
//
//    @Value("${file.upload-dir}")
//    private String uploadDir;
//
//    private Path route;
//
//    @PostConstruct
//    public void init() {
//
//        this.route = Paths.get(uploadDir);
//        try{
//            Files.createDirectory(route);
//        }catch (IOException e){
//            throw new RuntimeException("Echec d'initialization du repertoire de base");
//        }
//    }
//}
