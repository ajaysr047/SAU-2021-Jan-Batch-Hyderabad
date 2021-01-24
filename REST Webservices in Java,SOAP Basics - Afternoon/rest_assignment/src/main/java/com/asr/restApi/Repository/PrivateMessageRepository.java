package com.asr.restApi.Repository;

import com.asr.restApi.Entity.PrivateMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Integer> {
}
