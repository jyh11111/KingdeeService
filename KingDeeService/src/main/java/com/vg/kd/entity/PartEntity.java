package com.vg.kd.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@SuppressWarnings("serial")
@TableName("t_ICItemCore")
public class PartEntity extends SuperEntity<PartEntity> {
	//private Integer Fitemid;
	private String Fnumber;
	private String Fmodel;

}
