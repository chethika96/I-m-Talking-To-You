package com.sentura.ImTalkingToYou.Repository;

import com.sentura.ImTalkingToYou.Entity.Main_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainRepository extends JpaRepository<Main_Category,Long> {

    Main_Category findById(long Id);
    List<Main_Category> findByMainName(String name);

}
