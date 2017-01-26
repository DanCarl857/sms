package org.skylabase.sms.service.Impl;

import org.skylabase.sms.domain.Receiver;
import org.skylabase.sms.repository.ReceiverRepository;
import org.skylabase.sms.service.ReceiverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by daniel on 1/26/17.
 */
@Service
public class ReceiverServiceImpl implements ReceiverService {

    private static final Logger logger = LoggerFactory.getLogger(ReceiverServiceImpl.class);

    @Autowired
    ReceiverRepository receiverRepository;

    @Override
    public Collection<Receiver> findAll(){
        logger.info("Getting all receivers");
        Collection<Receiver> receivers = receiverRepository.findAll();
        return receivers;
    }

    @Override
    public Receiver findOne(Long id){
        logger.info("Getting receiver with id = " + id);
        Receiver rec = receiverRepository.findOne(id);
        return rec;
    }

    @Override
    public Receiver create(Receiver rec){
        if(rec.getId() != null){
            logger.error("Error creating receiver");
            return null;
        }
        logger.info("Creating a receiver");
        Receiver createRec = receiverRepository.save(rec);
        return createRec;
    }

    @Override
    public Receiver update(Receiver rec){
        Receiver persistentRec = this.findOne(rec.getId());

        if(persistentRec == null){
            logger.error("Error updating receiver. Receiver does not exist");
            return null;
        }
        logger.info("Updating receiver");
        Receiver updatedRec = receiverRepository.save(rec);
        return updatedRec;
    }

    @Override
    public void delete(Long id){
        logger.info("Deleting receiver");
        receiverRepository.delete(id);
    }
}
