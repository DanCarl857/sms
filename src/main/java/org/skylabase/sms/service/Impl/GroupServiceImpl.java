package org.skylabase.sms.service.Impl;

import org.skylabase.sms.domain.Group;
import org.skylabase.sms.repository.GroupRepository;
import org.skylabase.sms.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by daniel on 1/26/17.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public Collection<Group> findAll() {
        Collection<Group> groups = groupRepository.findAll();
        return groups;
    }

    @Override
    public Group findOne(Long id) {

        Group group = groupRepository.findOne(id);

        if(group == null){
            return null;
        }
        return group;
    }

    @Override
    public Group create(Group group) {

        if(group.getId() != null){
            return null;
        }
        Group createdGroup = groupRepository.save(group);
        return createdGroup;
    }

    @Override
    public Group update(Group group) {

        if(group.getId() == null){
            return null;
        }
        Group updatedGroup = groupRepository.save(group);
        return updatedGroup;
    }

    @Override
    public void delete(Long id) {
        groupRepository.delete(id);
    }
}
