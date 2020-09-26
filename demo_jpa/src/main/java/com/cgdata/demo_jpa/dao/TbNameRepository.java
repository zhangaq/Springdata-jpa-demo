package com.cgdata.demo_jpa.dao;

import com.cgdata.demo_jpa.domain.TbName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbNameRepository extends JpaRepository<TbName,Long> {
}
