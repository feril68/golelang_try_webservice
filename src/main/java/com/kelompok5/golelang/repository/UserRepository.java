package com.kelompok5.golelang.repository;

import com.kelompok5.golelang.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String username);

    Iterable<User> findAll();
}
