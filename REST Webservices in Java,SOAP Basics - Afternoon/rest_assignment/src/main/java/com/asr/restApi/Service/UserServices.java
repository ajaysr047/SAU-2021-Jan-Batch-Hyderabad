package com.asr.restApi.Service;

import com.asr.restApi.Entity.User;

public interface UserServices {

    public User addUser(User user);
    public User getUserById(Integer id);
    public User login(Integer id, String password);
    public User changeEmail(Integer id, String password, String email);
    public boolean deleteUser(Integer id);
}
