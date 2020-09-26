package com.cgdata.demo_jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

/**
 * @Description  
 * @Author  linmengmeng
 * @Date 2020-09-26 22:43:35 
 */

@Entity
@Table ( name ="test" , schema = "")
public class Test  implements Serializable {

	private static final long serialVersionUID =  8322145439334236848L;

	/**
	 * 主键索引
	 */
	@Id
   	@Column(name = "id" )
	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "{" +
					"id='" + id + '\'' +
				'}';
	}

}
