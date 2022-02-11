package com.haydikodlayalim.repository;

import com.haydikodlayalim.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author PUNHAN
 * @created 09/02/2022
 * @project spring-boot-jwt
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query(value = "SELECT U.USER_NAME FROM USERS U.USER_NAME = 1")
//    User finByUserName();

    boolean existsByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    boolean checkExistence(String userName);
/*
    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    User findByUserName(String userName);*/

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    User findByUserName(String userName);

  /*  @Query("SELECT u FROM User u WHERE u.password = ?1")
    User findByUserPassword(String userName);*/
}
