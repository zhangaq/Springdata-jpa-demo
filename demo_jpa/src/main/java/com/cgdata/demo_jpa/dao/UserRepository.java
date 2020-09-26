package com.cgdata.demo_jpa.dao;

import com.cgdata.demo_jpa.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDO,Integer>{

}
