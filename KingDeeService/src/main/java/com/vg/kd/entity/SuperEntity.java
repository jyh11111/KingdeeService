package com.vg.kd.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 演示实体父类
 */
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID , 这里故意演示注解可以无
     */
	@TableId(value="FItemId",type=IdType.INPUT)
    private Integer FItemID;   
  
 

    @Override
    protected Serializable pkVal() {
        return this.FItemID;
    }




	public Integer getFItemID() {
		return FItemID;
	}




	public void setFItemID(Integer fItemID) {
		FItemID = fItemID;
	}
}
