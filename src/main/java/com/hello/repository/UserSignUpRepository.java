package com.hello.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hello.entity.UserSignUp;

@Repository
@Transactional
public interface UserSignUpRepository extends CrudRepository<UserSignUp, Integer> {

}
