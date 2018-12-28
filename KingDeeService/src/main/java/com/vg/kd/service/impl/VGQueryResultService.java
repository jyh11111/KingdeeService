package com.vg.kd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vg.kd.entity.QueryResultEntity;
 
import com.vg.kd.mapper.VGQueryResultMapper;
import com.vg.kd.service.IQueryService;
 
@Service("vgQueryResultService")
@DS("db2")
public class VGQueryResultService extends ServiceImpl<VGQueryResultMapper, QueryResultEntity> implements IQueryService  {
	
	 
	public List<QueryResultEntity> selectQueryPage(Page page,@Param("param") QueryResultEntity param  )
	{	 
		return super.baseMapper.selectQueryPage(page, param);
	}
	 
	public List<QueryResultEntity> selectQueryList(@Param("param") QueryResultEntity param,@Param("current") Long current,@Param("size") Long size  ){
		return super.baseMapper.selectQueryList(param, current, size);
	}	
	 
	public Long whereCount(@Param("param") QueryResultEntity param ) {
		return super.baseMapper.whereCount(param);
	}
 
	public Map<String,Object> selectbyPartNumber(String fnumber ){
		return super.baseMapper.selectbyPartNumber(fnumber);
	}
 

}
