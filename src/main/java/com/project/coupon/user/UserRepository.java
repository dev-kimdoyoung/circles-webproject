package com.project.coupon.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    User save(User user);

    @Override
    List<User> findAll();

    @Override
    void deleteById(Integer user_id);

    @Override
    void flush();
}
