package org.skylabase.sms.repository;

import org.skylabase.sms.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daniel on 1/27/17.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
