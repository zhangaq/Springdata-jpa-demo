package com.cgdata.demo_jpa.controller;

import com.cgdata.demo_jpa.dao.TbNameRepository;
import com.cgdata.demo_jpa.domain.TbName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin//跨域
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private TbNameRepository tbNameRepository;

    @GetMapping(value = {"save1","save2"})
    public String save(@RequestParam("t1") String t1,@RequestParam("t2") String t2,@RequestParam("t3") String t3){
        TbName t = new TbName();
        t.setT1(t1);
        t.setT2(t2);
        t.setT3(t3);
        tbNameRepository.save(t);
        return "views/index";
    }

}
