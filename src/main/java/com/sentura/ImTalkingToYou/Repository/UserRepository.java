package com.sentura.ImTalkingToYou.Repository;

import com.sentura.ImTalkingToYou.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

  /*  List<User> findUserByActiveTrue();*/

    User findFirstByEmail(String email);
    User findFirstById(Long id);

    @Query("select s from User s where fName like %?1% or lName like %?1%")
    List<User> findByFNameOrLName(String name);
}
