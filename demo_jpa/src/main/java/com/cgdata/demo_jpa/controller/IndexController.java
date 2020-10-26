package com.cgdata.demo_jpa.controller;

import com.cgdata.demo_jpa.dao.TbNameRepository;
import com.cgdata.demo_jpa.domain.TbName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

//@RestController
@Controller
@CrossOrigin//跨域
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private TbNameRepository tbNameRepository;

    @ResponseBody//返回字符串
    @RequestMapping(value = {"/save"},method = RequestMethod.GET)
    public String save(@RequestParam("t1") String t1,@RequestParam("t2") String t2,@RequestParam("t3") String t3){
        TbName t = new TbName();
        t.setT1(t1);
        t.setT2(t2);
        t.setT3(t3);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        t.setCreatetime(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH,1);
        t.setUpdatetime(calendar.getTime());
        tbNameRepository.save(t);
        return "save success";
    }

    //返回index.html页面
    @GetMapping(value = {"/save1","/save2"})
    public String saveOne(@RequestParam("t1") String t1,@RequestParam("t2") String t2,@RequestParam("t3") String t3){
        TbName t = new TbName();
        t.setT1(t1);
        t.setT2(t2);
        t.setT3(t3);
        tbNameRepository.save(t);
        return "views/index";
    }

    @ResponseBody
    @GetMapping(value = "/query/{id}")
    public Object queryById(@PathVariable long id){
        TbName tbName = tbNameRepository.queryById(id);
        return tbName.toString();
    }

    @ResponseBody
//    @PutMapping("/update/{id}/{t1}")//用来整体更新一个资源，所以请求中必须包含完整的资源信息。如果缺少不分信息，会导致这部分数据被更新为null
//    @PatchMapping("/update/{id}/{t1}")//部分更新，仅更新提供的字段，请求中缺少的字段仍保持不变。
    @GetMapping("/update/{id}/{t1}")
    public String update(@PathVariable long id, @PathVariable String t1){
        int i = tbNameRepository.updateT1ById(t1, id);
        if (i<=0){
            return "update fail";
        }
        return "update success";
    }



}
