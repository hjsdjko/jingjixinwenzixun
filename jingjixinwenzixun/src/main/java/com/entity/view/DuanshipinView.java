package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DuanshipinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 短视频信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("duanshipin")
public class DuanshipinView extends DuanshipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 短视频类型的值
	*/
	@ColumnInfo(comment="短视频类型的字典表值",type="varchar(200)")
	private String duanshipinValue;




	public DuanshipinView() {

	}

	public DuanshipinView(DuanshipinEntity duanshipinEntity) {
		try {
			BeanUtils.copyProperties(this, duanshipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 短视频类型的值
	*/
	public String getDuanshipinValue() {
		return duanshipinValue;
	}
	/**
	* 设置： 短视频类型的值
	*/
	public void setDuanshipinValue(String duanshipinValue) {
		this.duanshipinValue = duanshipinValue;
	}




	@Override
	public String toString() {
		return "DuanshipinView{" +
			", duanshipinValue=" + duanshipinValue +
			"} " + super.toString();
	}
}
