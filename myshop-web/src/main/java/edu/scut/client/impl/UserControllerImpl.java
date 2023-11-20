package edu.scut.client.impl;

import edu.scut.client.UserController;
import edu.scut.entity.User;

public class UserControllerImpl implements UserController {
    @Override
    public User findById(Integer id) {
        System.out.println("执行了熔断器类");
        return null;
    }
}
