package org.skylabase.sms.repository;

import org.skylabase.sms.domain.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by daniel on 1/26/17.
 */
@Repository
public interface ReceiverRepository extends JpaRepository<Receiver, Long> {

    Receiver findByFirstName(@Param(value="firstName") String firstName);

    Receiver findByLastName(@Param(value="lastName") String lastName);

    Receiver findByPhoneNumber(@Param(value="phoneNumber") String phoneNumber);
}
