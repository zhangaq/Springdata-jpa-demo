package com.cgdata.demo_jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author  linmengmeng
 * @Date 2020-09-24 23:51:50 
 */

@Entity
@Table ( name ="tb_name" )
@Data
public class TbName  implements Serializable {

	private static final long serialVersionUID =  6006110891772928398L;

   	@Column(name = "t1" )
	private String t1;

   	@Column(name = "t2" )
	private String t2;

   	@Column(name = "t3")
	private String t3;

	/**
	 * 索引
	 */
	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)//新增方法没有指定主键时，自动添加主键
	private Long id;


}
