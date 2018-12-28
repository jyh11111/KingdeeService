package com.vg.kd.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vg.kd.entity.PartEntity;
import com.vg.kd.mapper.PartMapper;
import com.vg.kd.service.IPartService;
 
@Service
public class PartServiceImpl  extends ServiceImpl<PartMapper,PartEntity> implements  IPartService{
 

}
