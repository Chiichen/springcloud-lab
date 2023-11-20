package edu.scut.service;

import edu.scut.entity.User;
import edu.scut.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findById(Integer id) {
        return userMapper.findById(id).get();
    }

    public void add(User user) {
        userMapper.save(user);
    }

    public void update(User user) {
        userMapper.save(user);
    }

    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
