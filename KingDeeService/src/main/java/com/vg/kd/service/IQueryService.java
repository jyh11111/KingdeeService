package com.vg.kd.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vg.kd.entity.QueryResultEntity;
 
public interface IQueryService extends IService<QueryResultEntity> {
	public List<QueryResultEntity> selectQueryPage(Page page, @Param("param") QueryResultEntity param );

	public List<QueryResultEntity> selectQueryList(@Param("param") QueryResultEntity param,
			@Param("current") Long current, @Param("size") Long size );

	public Long whereCount(@Param("param") QueryResultEntity param );
	public Map<String,Object> selectbyPartNumber(String fnumber );

}
