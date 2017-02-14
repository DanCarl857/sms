package org.skylabase.sms.service.Impl;

import org.skylabase.sms.domain.Message;
import org.skylabase.sms.domain.Receiver;
import org.skylabase.sms.repository.MessageRepository;
import org.skylabase.sms.service.MessageService;
import org.skylabase.sms.util.SendSMS;
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

        if(message == null){
            return null;
        }
        return message;
    }

    @Override
    public Message sendSMS(Message message, String fromName){
        /* send message to receivers */
        Message createdMessage;
        if(message.getId() != null){
            return null;
        }
        if (fromName == null){
            for(Receiver receivers: message.getReceivers()){
                String realPhoneNumber = receivers.getCountryCode() + receivers.getPhoneNumber();
                SendSMS.sendSMS(message.getUser().getUsername(), message.getMessage(), realPhoneNumber);
            }
            createdMessage = messageRepository.save(message);
        } else {
            for(Receiver receivers: message.getReceivers()){
                String realPhoneNumber = receivers.getCountryCode() + receivers.getPhoneNumber();
                SendSMS.sendSMS(message.getUser().getUsername(), message.getMessage(), realPhoneNumber, fromName);
            }
            createdMessage = messageRepository.save(message);
        }
        return createdMessage;
    }

    @Override
    public void delete(Long id){
        messageRepository.delete(id);
    }
}
