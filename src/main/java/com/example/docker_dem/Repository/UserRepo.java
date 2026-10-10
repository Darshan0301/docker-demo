package com.example.docker_dem.Repository;

import com.example.docker_dem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
