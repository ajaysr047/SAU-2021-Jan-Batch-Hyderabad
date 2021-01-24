package com.asr.restApi.Service.Implementation;

import com.asr.restApi.Entity.User;
import com.asr.restApi.Repository.UserRepository;
import com.asr.restApi.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        if(userRepository.findByEmailId(user.getEmailId()) == null){
            String plainPassword = user.getPassword();
            String encryptedPassword = getEncryptedPassword(plainPassword);
            user.setPassword(encryptedPassword);
            User savedUser = userRepository.save(user);
            return savedUser;
        }
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            return user.get();
        return null;
    }

    @Override
    public User login(Integer id, String password) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent() && isPasswordValid(password, user.get().getPassword()))
            return user.get();
        return null;
    }

    @Override
    public User changeEmail(Integer id, String password, String email) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent() && isPasswordValid(password, user.get().getPassword())) {
            user.get().setEmailId(email);
            return user.get();
        }
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

    private String getEncryptedPassword(String plainPassword) {
        return new BCryptPasswordEncoder().encode(plainPassword);
    }

    private boolean isPasswordValid(String inputPassword, String storedPassword){
        return new BCryptPasswordEncoder().matches(inputPassword, storedPassword);
    }
}
