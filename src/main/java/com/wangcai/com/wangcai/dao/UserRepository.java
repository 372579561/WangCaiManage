package com.wangcai.com.wangcai.dao;

import com.wangcai.com.wangcai.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
