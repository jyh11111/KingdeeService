package com.vg.kd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value="v_PartTmp")
public class PartTmpEntity extends SuperEntity<PartTmpEntity> {
/*	@TableId(value="FItemId",type=IdType.INPUT)
	private Integer Fitemid;*/	
	private Long id;
	private String Fnumber;
	private String Ptype;
	private String F1;
	private String V1;
	private String F2;
	private String V2;
	private String F3;
	private String V3;
	private String F4;
	private String V4;
	private String F5;
	private String V5;
	private String F6;
	private String V6;
 

}
