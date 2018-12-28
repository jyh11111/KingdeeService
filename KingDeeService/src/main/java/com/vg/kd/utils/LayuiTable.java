package com.vg.kd.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.vg.kd.entity.QueryResultEntity;

public class LayuiTable extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	public static LayuiTable tableData(IPage page){ //这个page中有可能变成小写了
		LayuiTable tableData = new LayuiTable();
		tableData.put("code", 0);
		tableData.put("msg", "");
		tableData.put("count", page.getTotal());
		tableData.put("data", page.getRecords());
		//==上面为Layui数据表格所需要的
		tableData.put("size", page.getSize());
		tableData.put("current", page.getCurrent());
		return tableData;
	 }
	
	public static LayuiTable tableData(List<Map<String,Object>> list,long l){
		LayuiTable tableData = new LayuiTable();
		tableData.put("code", 0);
		tableData.put("msg", "");
		tableData.put("count", l);
		tableData.put("data", list);
		//==上面为Layui数据表格所需要的
		
		return tableData;
	 }
	
  
 
 


}
