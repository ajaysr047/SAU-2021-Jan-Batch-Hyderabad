package com.asr.restApi.Controller;

import com.asr.restApi.Entity.PrivateMessage;
import com.asr.restApi.Entity.User;
import com.asr.restApi.Service.PrivateMessageServices;
import com.asr.restApi.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class PrivateMessageController {

    @Autowired
    UserServices userServices;

    @Autowired
    PrivateMessageServices privateMessageServices;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Object> postMessage(@RequestBody PrivateMessage privateMessage, @PathVariable("userId") Integer userId){
        User user = userServices.getUserById(userId);
        if(user != null){
            privateMessage.setUserId(user.getId());
            PrivateMessage sentMessage = privateMessageServices.add(privateMessage);
            return ResponseEntity.ok(sentMessage);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

    }
}
