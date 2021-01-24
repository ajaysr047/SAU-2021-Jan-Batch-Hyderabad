package com.asr.restApi.Service;

import com.asr.restApi.Entity.PrivateMessage;

public interface PrivateMessageServices {
    public PrivateMessage add(PrivateMessage privateMessage);
    public boolean remove(Integer id);
}
