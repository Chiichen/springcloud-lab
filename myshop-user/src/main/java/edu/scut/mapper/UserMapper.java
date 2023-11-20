package edu.scut.mapper;

import edu.scut.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserMapper extends JpaRepository<User, Integer> {
}
