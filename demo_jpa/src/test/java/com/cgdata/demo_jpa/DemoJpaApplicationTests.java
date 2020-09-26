package com.cgdata.demo_jpa;

import com.cgdata.demo_jpa.dao.TbNameRepository;
import com.cgdata.demo_jpa.dao.UserRepository;
import com.cgdata.demo_jpa.domain.TbName;
import com.cgdata.demo_jpa.domain.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoJpaApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TbNameRepository tbNameRepository;

    @Test
    public void testFindAll1() {
        List<TbName> list = tbNameRepository.findAll();
        for (TbName user : list) {
            System.out.println("user_name:" + user.getT1());
        }
    }

    @Test
    public void testSave(){
        TbName tbName = new TbName();
//        tbName.setId(3l);
        tbName.setT1("130");
        tbName.setT2("3");
        tbName.setT3("1");
        tbNameRepository.save(tbName);
    }

    @Test
    public void testFindAll() {
        List<UserDO> list = userRepository.findAll();
        for (UserDO user : list) {
            System.out.println("user_name:" + user.getUserName());
        }
    }



}
