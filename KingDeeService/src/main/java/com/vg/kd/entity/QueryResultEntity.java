package com.vg.kd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value="v_PartTmp")
public class QueryResultEntity extends SuperEntity<QueryResultEntity>{
	
	//还有一个 private Integer FItemID; //为key   
	private Long id;
	 
	private String FNumber; //物料编号
	private String Ptype;
	private String F1;
	private String V1; //属性1值
	private String F2;
	private String V2;//属性2值
	private String F3;
	private String V3;//属性3值
	private String F4;
	private String V4;//属性4值
	private String F5;
	private String V5;//属性5值
	private String F6;
	private String V6;//属性6值
// ===下面有
	@TableField(exist = false)
	private String FName;//物料名称
	@TableField(exist = false)
	private String SupplyName; //供应商名称
	@TableField(exist = false)
	private String  E8PN ;// F_108;//E8旧编号
	@TableField(exist = false)
	private String E10PN;// F_109;//E10旧编码
	
//==下面是参数 用来传参，不是用来显示的
	@TableField(exist = false)
	private String FShortNumber; //
//	@TableField(exist = false)
//	private String ascField; //升序排序字段
//	@TableField(exist = false)
//	private String descField; // 降序排序字段
	@TableField(exist = false)
	private String supply; //这个只针对于马达，这个是Fnumber 中间那个C 等等代表供应商
	@TableField(exist = false)
	private String supplyord; //这个只针对马达,这个是供应商数字例如:15
//==传参结束	
	
	
	
	
	
	
	
}
