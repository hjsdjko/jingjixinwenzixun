package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DuanshipinLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 短视频留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("duanshipin_liuyan")
public class DuanshipinLiuyanView extends DuanshipinLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 短视频信息
		/**
		* 短视频名称
		*/

		@ColumnInfo(comment="短视频名称",type="varchar(200)")
		private String duanshipinName;
		/**
		* 短视频照片
		*/

		@ColumnInfo(comment="短视频照片",type="varchar(200)")
		private String duanshipinPhoto;
		/**
		* 短视频视频
		*/

		@ColumnInfo(comment="短视频视频",type="varchar(200)")
		private String duanshipinVideo;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(111)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(111)")
		private Integer caiNumber;
		/**
		* 短视频类型
		*/
		@ColumnInfo(comment="短视频类型",type="int(11)")
		private Integer duanshipinTypes;
			/**
			* 短视频类型的值
			*/
			@ColumnInfo(comment="短视频类型的字典表值",type="varchar(200)")
			private String duanshipinValue;
		/**
		* 详情
		*/

		@ColumnInfo(comment="详情",type="text")
		private String duanshipinContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer duanshipinDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;



	public DuanshipinLiuyanView() {

	}

	public DuanshipinLiuyanView(DuanshipinLiuyanEntity duanshipinLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, duanshipinLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 短视频信息

		/**
		* 获取： 短视频名称
		*/
		public String getDuanshipinName() {
			return duanshipinName;
		}
		/**
		* 设置： 短视频名称
		*/
		public void setDuanshipinName(String duanshipinName) {
			this.duanshipinName = duanshipinName;
		}

		/**
		* 获取： 短视频照片
		*/
		public String getDuanshipinPhoto() {
			return duanshipinPhoto;
		}
		/**
		* 设置： 短视频照片
		*/
		public void setDuanshipinPhoto(String duanshipinPhoto) {
			this.duanshipinPhoto = duanshipinPhoto;
		}

		/**
		* 获取： 短视频视频
		*/
		public String getDuanshipinVideo() {
			return duanshipinVideo;
		}
		/**
		* 设置： 短视频视频
		*/
		public void setDuanshipinVideo(String duanshipinVideo) {
			this.duanshipinVideo = duanshipinVideo;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 短视频类型
		*/
		public Integer getDuanshipinTypes() {
			return duanshipinTypes;
		}
		/**
		* 设置： 短视频类型
		*/
		public void setDuanshipinTypes(Integer duanshipinTypes) {
			this.duanshipinTypes = duanshipinTypes;
		}


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

		/**
		* 获取： 详情
		*/
		public String getDuanshipinContent() {
			return duanshipinContent;
		}
		/**
		* 设置： 详情
		*/
		public void setDuanshipinContent(String duanshipinContent) {
			this.duanshipinContent = duanshipinContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getDuanshipinDelete() {
			return duanshipinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setDuanshipinDelete(Integer duanshipinDelete) {
			this.duanshipinDelete = duanshipinDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 假删
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "DuanshipinLiuyanView{" +
			", duanshipinName=" + duanshipinName +
			", duanshipinPhoto=" + duanshipinPhoto +
			", duanshipinVideo=" + duanshipinVideo +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", duanshipinContent=" + duanshipinContent +
			", duanshipinDelete=" + duanshipinDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
