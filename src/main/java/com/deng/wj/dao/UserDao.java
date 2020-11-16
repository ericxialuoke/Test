package com.deng.wj.dao;

import com.deng.wj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

//    String findUserAllprivileges(String id);

    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);
}
