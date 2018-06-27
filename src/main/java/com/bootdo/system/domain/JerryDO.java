package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-23 15:54:20
 */
public class JerryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer jid;
	//
	private String name;

	/**
	 * 设置：
	 */
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	/**
	 * 获取：
	 */
	public Integer getJid() {
		return jid;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
}
