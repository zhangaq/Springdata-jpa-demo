package com.cgdata.demo_jpa.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user")
@Data
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//新增方法没有指定主键时，自动添加主键
    private Integer id;
    @Column(name="user_name",length = 200)
    private String userName;
    @Column(name="password",length = 200)
    private String password;
    @Column(name="sex")
    private Integer sex;
    @Column(name="last_login_time")
    private Date lastLoginTime;


}
