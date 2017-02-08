package org.skylabase.sms.repository;

import org.skylabase.sms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by daniel on 1/26/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(@Param(value="username") String username);
}
