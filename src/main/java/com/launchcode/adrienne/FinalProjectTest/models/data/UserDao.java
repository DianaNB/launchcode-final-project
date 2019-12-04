package com.launchcode.adrienne.FinalProjectTest.models.data;


import com.launchcode.adrienne.FinalProjectTest.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User,Integer> {
    User findByUsername(String username);


}
