package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 短视频信息
 *
 * @author 
 * @email
 */
@TableName("duanshipin")
public class DuanshipinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DuanshipinEntity() {

	}

	public DuanshipinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 短视频名称
     */
    @ColumnInfo(comment="短视频名称",type="varchar(200)")
    @TableField(value = "duanshipin_name")

    private String duanshipinName;


    /**
     * 短视频照片
     */
    @ColumnInfo(comment="短视频照片",type="varchar(200)")
    @TableField(value = "duanshipin_photo")

    private String duanshipinPhoto;


    /**
     * 短视频视频
     */
    @ColumnInfo(comment="短视频视频",type="varchar(200)")
    @TableField(value = "duanshipin_video")

    private String duanshipinVideo;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(111)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(111)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 短视频类型
     */
    @ColumnInfo(comment="短视频类型",type="int(11)")
    @TableField(value = "duanshipin_types")

    private Integer duanshipinTypes;


    /**
     * 详情
     */
    @ColumnInfo(comment="详情",type="text")
    @TableField(value = "duanshipin_content")

    private String duanshipinContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "duanshipin_delete")

    private Integer duanshipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：短视频名称
	 */
    public String getDuanshipinName() {
        return duanshipinName;
    }
    /**
	 * 设置：短视频名称
	 */

    public void setDuanshipinName(String duanshipinName) {
        this.duanshipinName = duanshipinName;
    }
    /**
	 * 获取：短视频照片
	 */
    public String getDuanshipinPhoto() {
        return duanshipinPhoto;
    }
    /**
	 * 设置：短视频照片
	 */

    public void setDuanshipinPhoto(String duanshipinPhoto) {
        this.duanshipinPhoto = duanshipinPhoto;
    }
    /**
	 * 获取：短视频视频
	 */
    public String getDuanshipinVideo() {
        return duanshipinVideo;
    }
    /**
	 * 设置：短视频视频
	 */

    public void setDuanshipinVideo(String duanshipinVideo) {
        this.duanshipinVideo = duanshipinVideo;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：短视频类型
	 */
    public Integer getDuanshipinTypes() {
        return duanshipinTypes;
    }
    /**
	 * 设置：短视频类型
	 */

    public void setDuanshipinTypes(Integer duanshipinTypes) {
        this.duanshipinTypes = duanshipinTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getDuanshipinContent() {
        return duanshipinContent;
    }
    /**
	 * 设置：详情
	 */

    public void setDuanshipinContent(String duanshipinContent) {
        this.duanshipinContent = duanshipinContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDuanshipinDelete() {
        return duanshipinDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDuanshipinDelete(Integer duanshipinDelete) {
        this.duanshipinDelete = duanshipinDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Duanshipin{" +
            ", id=" + id +
            ", duanshipinName=" + duanshipinName +
            ", duanshipinPhoto=" + duanshipinPhoto +
            ", duanshipinVideo=" + duanshipinVideo +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", duanshipinTypes=" + duanshipinTypes +
            ", duanshipinContent=" + duanshipinContent +
            ", duanshipinDelete=" + duanshipinDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
