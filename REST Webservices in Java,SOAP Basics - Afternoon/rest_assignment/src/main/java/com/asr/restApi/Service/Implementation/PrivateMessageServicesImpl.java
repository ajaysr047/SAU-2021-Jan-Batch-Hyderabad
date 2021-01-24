package com.asr.restApi.Service.Implementation;

import com.asr.restApi.Entity.PrivateMessage;
import com.asr.restApi.Repository.PrivateMessageRepository;
import com.asr.restApi.Service.PrivateMessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class PrivateMessageServicesImpl implements PrivateMessageServices {

    @Autowired
    PrivateMessageRepository privateMessageRepository;

    @Override
    public PrivateMessage add(PrivateMessage privateMessage) {
        privateMessage.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        return privateMessageRepository.save(privateMessage);
    }

    @Override
    public boolean remove(Integer id) {
        Optional<PrivateMessage> privateMessage = privateMessageRepository.findById(id);
        if(privateMessage.isPresent()) {
            privateMessageRepository.delete(privateMessage.get());
            return true;
        }
        return false;
    }
}
