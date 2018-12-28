package com.vg.kd.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vg.kd.entity.PartTmpEntity;

public interface IPartTmpService extends IService<PartTmpEntity> {
	
	public List<Map<String, Object>> QueryPart(IPage<PartTmpEntity> page);

}
