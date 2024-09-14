package com.example.homerent.repository;

import com.example.homerent.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    @Query("select user.username from UserEntity user where user.username=:email")
    Optional<String> findUserByEmail(String email);

    Optional<UserEntity> findByUsername(String username);

    @Query(value = "update UserEntity user set user.password=:newPassword where user.username=:email")
    void updatePassword(String email, String newPassword);


}

//   //jpql query
//    @Query("select U from  UserEntity U where u.firstName=:firstName and U.lastName=:lastName and U.username=:userName")
//    Optional<UserEntity> findByUser(String firstName, String lastName, String userName);
//
//    //method Query
//    Optional<UserEntity> findByFirstNameAndLastName(String firstName, String lastName);
//
//     //native Query
//    @Query(value = "SELECT count(*) from users ", nativeQuery = true)
//    List<UserEntity> findAllUser();
