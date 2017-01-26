package org.skylabase.sms.service;

import org.skylabase.sms.domain.Group;

import java.util.Collection;

/**
 * Created by daniel on 1/26/17.
 */
public interface GroupService {

    Collection<Group> findAll();

    Group findOne(Long id);

    Group create(Group group);

    Group update(Group group);

    void delete(Long id);
}
