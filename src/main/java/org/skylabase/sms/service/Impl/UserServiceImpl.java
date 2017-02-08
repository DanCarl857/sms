package org.skylabase.sms.service.Impl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public Collection<User> findAll() {
        logger.info("Getting all users");
        Collection<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findOne(Long id) {
        logger.info("Getting user with id = " + id);
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public User create(User user){

        if(user.getId() != null){
            logger.error("Error creating user");
            return null;
        }
        logger.info("Creating user");
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    public User update(User user){

        User persistentUser = findOne(user.getId());

        if (persistentUser == null) {
            logger.error("error updating user");
            return null;
        }
        logger.info("Updating user");
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public void delete(Long id) {
        logger.info("deleting user");
        userRepository.delete(id);
    }
}
