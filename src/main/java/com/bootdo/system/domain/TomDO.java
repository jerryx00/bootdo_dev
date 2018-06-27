package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-23 20:06:42
 */
public class TomDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer tid;
	//名称
	private String name;
	//父ID
	private Integer jid;

	/**
	 * 设置：ID
	 */
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	/**
	 * 获取：ID
	 */
	public Integer getTid() {
		return tid;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：父ID
	 */
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	/**
	 * 获取：父ID
	 */
	public Integer getJid() {
		return jid;
	}
}
