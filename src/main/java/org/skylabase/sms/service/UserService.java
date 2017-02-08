package org.skylabase.sms.service;

import org.skylabase.sms.domain.User;

import java.util.Collection;

/**
 * Created by daniel on 1/26/17.
 */
public interface UserService {

    Collection<User> findAll();

    User findOne(Long id);

    User findByUsername(String username);

    User create(User user);

    User update(User user);

    void delete(Long id);
}
