package com.struc.base.userapi.services.impl;


import com.struc.base.framework.annotation.FLAutowired;
import com.struc.base.framework.annotation.FLService;
import com.struc.base.userapi.services.IModifyService;
import com.struc.base.userapi.services.IQueryService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 查询业务
 * @author Tom
 *
 */
@FLService
public class QueryService implements IQueryService {

	@FLAutowired
	IModifyService modifyService;

	public void updateInfo( String name ){
		String dd = modifyService.add( name , "test_address" );
		System.out.println( "result:" +dd );
	}

	/**
	 * 查询
	 */
	public String query(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		String json = "{name:\"" + name + "\",time:\"" + time + "\"}";
		return json;
	}

}
