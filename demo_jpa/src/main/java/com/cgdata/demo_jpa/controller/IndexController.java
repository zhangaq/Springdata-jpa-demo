package com.cgdata.demo_jpa.controller;

import com.cgdata.demo_jpa.dao.TbNameRepository;
import com.cgdata.demo_jpa.domain.TbName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

//@RestController
@Api(value = "IndexController|首页控制器test",description = "首页管理，提供页面的增、删、改、查")
@Slf4j
@Controller
@CrossOrigin//跨域
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private TbNameRepository tbNameRepository;

    @ApiOperation(value = "新增t1,t2,t3",notes = "",produces = MediaType.APPLICATION_JSON_VALUE)
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
        log.info("测试日志");
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

    @ApiOperation(value = "根据id查询")
    @ResponseBody
    @GetMapping(value = "/query/{id}")
    public Object queryById(@PathVariable long id){
        TbName tbName = tbNameRepository.queryById(id);
        log.info("测试日志");
        return tbName.toString();
    }

    @ApiOperation(value = "根据id修改t1的值")
    @ResponseBody
//    @PutMapping("/update/{id}/{t1}")//用来整体更新一个资源，所以请求中必须包含完整的资源信息。如果缺少部分信息，会导致这部分数据被更新为null
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
