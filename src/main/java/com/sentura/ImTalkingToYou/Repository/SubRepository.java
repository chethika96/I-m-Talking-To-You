package com.sentura.ImTalkingToYou.Repository;

import com.sentura.ImTalkingToYou.Entity.Sub_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubRepository extends JpaRepository<Sub_Category,Long> {


    Sub_Category findById(long id);
/*   List< Sub_Category> findBySub_Name(String name);*/
}
