package com.cgdata.demo_jpa.dao;

import com.cgdata.demo_jpa.domain.TbName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TbNameRepository extends JpaRepository<TbName,Long> {

    @Query(value = "select id,t1,t2,t3,create_time,update_time from tb_name where id = ?1 ", nativeQuery = true)
    TbName queryById(long id);

    @Transactional
    @Query(value = " update tb_name set t1 = ?1 where id = ?2 ", nativeQuery = true)
    @Modifying//@Query 与 @ Modifying 这 两 个 annotation 一起声明，可定义个性化更新操作，例如只涉及某些字段更新时最为常用，
    int updateT1ById(String t1,long id);

}
