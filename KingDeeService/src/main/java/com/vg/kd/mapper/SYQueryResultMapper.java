package com.vg.kd.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vg.kd.SuperMapper; 
import com.vg.kd.entity.QueryResultEntity;
 

public interface SYQueryResultMapper  extends SuperMapper<QueryResultEntity> {
	
	//F_106这个是麻涌培训实操帐套的供应商对应的字段名称
	 //下面这个可分页....
	public List<QueryResultEntity> selectQueryList(@Param("param") QueryResultEntity param,@Param("current") Long current,@Param("size") Long size );	
	
	public Long whereCount(@Param("param") QueryResultEntity param);

	public List<QueryResultEntity> selectQueryPage(Page page,@Param("param") QueryResultEntity param );
	
	//根据Fnubmer 从视图中t_IcItem中提取资料
	//FErpClsID (1-外购 2-自制 3-委外加工,5虚拟件 6-特征类,7-配置类 8-规划类 9-组装件 13（特性自）
	@Select(value="select * from t_IcItem where FNumber=#{fnumber}")
	public Map<String,Object> selectbyPartNumber(String fnumber);

}
