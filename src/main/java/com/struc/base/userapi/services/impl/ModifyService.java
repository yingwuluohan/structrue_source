package com.struc.base.userapi.services.impl;


import com.struc.base.framework.annotation.FLService;
import com.struc.base.userapi.services.IModifyService;

/**
 * 增删改业务
 * @author Tom
 *
 */
@FLService
public class ModifyService implements IModifyService {

	/**
	 * 增加
	 */
	public String add(String name,String addr) {
		System.out.println( "" + name );
		return "modifyService add,name=" + name + ",addr=" + addr;
	}

	/**
	 * 修改
	 */
	public String edit(Integer id,String name) {
		System.out.println( "update:" + name );
		return "modifyService edit,id=" + id + ",name=" + name;
	}

	/**
	 * 删除
	 */
	public String remove(Integer id) {
		return "modifyService id=" + id;
	}
	
}
