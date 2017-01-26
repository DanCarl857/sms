package org.skylabase.sms.service.Impl;

import org.skylabase.sms.domain.User;
import org.skylabase.sms.repository.UserRepository;
import org.skylabase.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by daniel on 1/26/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Collection<User> findAll() {
        Collection<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User findOne(Long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public User create(User user){

        if(user.getId() != null){
            return null;
        }
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    public User update(User user){

        User persistentUser = findOne(user.getId());

        if (persistentUser == null) {
            return null;
        }
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
