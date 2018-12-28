package com.vg.kd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vg.kd.entity.PartTmpEntity;
import com.vg.kd.mapper.PartTmpMapper;
import com.vg.kd.service.IPartTmpService;
 

@Service
 
public class PartTmpServiceImpl extends ServiceImpl<PartTmpMapper, PartTmpEntity> implements IPartTmpService {

	@Autowired
	private PartTmpMapper partMapper;
 
	public List<Map<String, Object>> QueryPart(IPage<PartTmpEntity> page) {
		List<PartTmpEntity> list = page.getRecords();
		//Integer len = list.size();
		List<Integer> listIds = new ArrayList<>();

		list.forEach(obj -> {
			listIds.add(obj.getFItemID());
		});
		//System.out.println(listIds);
		String ids;
		if (listIds.size()==0) {
			ids="0";
		}
		else
		{ ids =StringUtils.collectionToDelimitedString(listIds, ",");   }
		
		 
			
		return partMapper.QueryPart(ids );
	}
}
