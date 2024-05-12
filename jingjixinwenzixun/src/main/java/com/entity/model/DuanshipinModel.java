package com.entity.model;

import com.entity.DuanshipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 短视频信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DuanshipinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 短视频名称
     */
    private String duanshipinName;


    /**
     * 短视频照片
     */
    private String duanshipinPhoto;


    /**
     * 短视频视频
     */
    private String duanshipinVideo;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 短视频类型
     */
    private Integer duanshipinTypes;


    /**
     * 详情
     */
    private String duanshipinContent;


    /**
     * 逻辑删除
     */
    private Integer duanshipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
