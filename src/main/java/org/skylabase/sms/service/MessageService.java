package org.skylabase.sms.service;

import org.skylabase.sms.domain.Message;

import java.util.Collection;

/**
 * Created by daniel on 1/27/17.
 */
public interface MessageService {

    Collection<Message> findAll();

    Message findOne(Long id);

    Message create(Message message);

    void delete(Long id);
}
