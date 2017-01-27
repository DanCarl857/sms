package org.skylabase.sms.service.Impl;

import org.skylabase.sms.domain.Message;
import org.skylabase.sms.repository.MessageRepository;
import org.skylabase.sms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by daniel on 1/27/17.
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Collection<Message> findAll(){
        Collection<Message> messages = messageRepository.findAll();
        return messages;
    }

    @Override
    public Message findOne(Long id){
        Message message = messageRepository.findOne(id);
        return message;
    }

    @Override
    public Message create(Message message){
        if(message.getId() != null){
            return null;
        }
        Message createdMessage = messageRepository.save(message);
        return createdMessage;
    }

    @Override
    public void delete(Long id){
        messageRepository.delete(id);
    }
}
