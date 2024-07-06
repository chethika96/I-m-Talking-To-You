package com.sentura.ImTalkingToYou.Repository;

import com.sentura.ImTalkingToYou.Entity.Package_Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository <Package_Type,Long>{

Package_Type findByPackageName(String packageName);

}
