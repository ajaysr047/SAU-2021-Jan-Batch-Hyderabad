package com.asr.restApi.Controller;

import com.asr.restApi.Entity.PrivateMessage;
import com.asr.restApi.Entity.User;
import com.asr.restApi.Service.PrivateMessageServices;
import com.asr.restApi.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @Autowired
    PrivateMessageServices privateMessageServices;

    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@RequestBody Map<String, String> userData){

        User newUser = new User(userData.get("email"), userData.get("password"));

        User savedUser = userServices.addUser(newUser);
        if(savedUser != null)
            return ResponseEntity.ok(savedUser);
        return new ResponseEntity<>("Duplicate Email", HttpStatus.CONFLICT);
    }

    @GetMapping("/login/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable Integer userId, @RequestHeader("password") String password){
        User user = userServices.login(userId, password);
        if(user != null)
            return ResponseEntity.ok(user);
        return new ResponseEntity<>("Invalid Credentials", HttpStatus.EXPECTATION_FAILED);
    }

    @PutMapping("/updateEmail/{userId}")
    public ResponseEntity<Object> updateEmail(@PathVariable Integer userId, @RequestHeader("password") String password, @RequestHeader("email") String email){
        User user = userServices.changeEmail(userId, password, email);
        if(user != null)
            return ResponseEntity.ok(user);
        return new ResponseEntity<>("Invalid credentials", HttpStatus.EXPECTATION_FAILED);
    }

    @DeleteMapping("/deleteMessage/{userId}/{messageId}")
    public ResponseEntity<Object> deleteUserMessage(@PathVariable Integer userId, @PathVariable Integer messageId, @RequestHeader("password") String password) {
        User user = userServices.login(userId, password);
        if (user != null){
            boolean isRemoved = privateMessageServices.remove(messageId);
            if(isRemoved)
                return new ResponseEntity<>("Message deleted!", HttpStatus.OK);
            return new ResponseEntity<>("Message not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Invalid Credentials", HttpStatus.EXPECTATION_FAILED);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer userId, @RequestHeader("password") String password) {
        User user = userServices.login(userId, password);
        if (user != null){
            boolean isDeleted = userServices.deleteUser(userId);
            if(isDeleted)
                return new ResponseEntity<>("User deleted!", HttpStatus.OK);
            return new ResponseEntity<>("User couldn't be deleted!", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("Invalid Credentials/User not found", HttpStatus.EXPECTATION_FAILED);
    }


}
