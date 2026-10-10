package com.example.docker_dem.Service;

import com.example.docker_dem.Entity.User;
import com.example.docker_dem.Repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Value("${file.path}")
    private String filePath;
    @Autowired
    private UserRepo userRepo;
    public UserService(){
    }
    public void addUser(User user) throws IOException {
        Path path=Path.of(filePath);
        Files.writeString(path,
                user.getName() + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

        userRepo.save(user);
    }
    public  List<String> getUserName() throws IOException{
        Path path=Path.of(filePath);
        return new ArrayList<>(Files.readAllLines(path));
    }
    public List<User> getUsers(){
        return userRepo.findAll();
    }
}
