package com.vg.kd.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vg.kd.SuperMapper;
import com.vg.kd.entity.PartTmpEntity;
 

 
public interface PartTmpMapper extends SuperMapper<PartTmpEntity> {
	
	//F_106这个是麻涌培训实操帐套的供应商对应的字段名称
 	@Select(value = { "select A.*, B.F_106  as SupplyName ,C.* from t_ICItem A inner join t_ICItemCustom B on A.FItemId=B.FItemId  inner join v_PartTmp C on A.FItemID=C.FItemID   where A.FItemId in (${ids})" })
 	public List<Map<String,Object>> QueryPart(@Param("ids") String ids );
	
  
 	
 	
}
