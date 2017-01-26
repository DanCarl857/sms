package org.skylabase.sms.service;

import org.skylabase.sms.domain.Receiver;

import java.util.Collection;

/**
 * Created by daniel on 1/26/17.
 */
public interface ReceiverService {

    Collection<Receiver> findAll();

    Receiver findOne(Long id);

    Receiver create(Receiver receiver);

    Receiver update(Receiver receiver);

    void delete(Long id);
}
