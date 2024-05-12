package com.entity.vo;

import com.entity.DuanshipinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 短视频信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("duanshipin")
public class DuanshipinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 短视频名称
     */

    @TableField(value = "duanshipin_name")
    private String duanshipinName;


    /**
     * 短视频照片
     */

    @TableField(value = "duanshipin_photo")
    private String duanshipinPhoto;


    /**
     * 短视频视频
     */

    @TableField(value = "duanshipin_video")
    private String duanshipinVideo;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 短视频类型
     */

    @TableField(value = "duanshipin_types")
    private Integer duanshipinTypes;


    /**
     * 详情
     */

    @TableField(value = "duanshipin_content")
    private String duanshipinContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "duanshipin_delete")
    private Integer duanshipinDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：短视频名称
	 */
    public String getDuanshipinName() {
        return duanshipinName;
    }


    /**
	 * 获取：短视频名称
	 */

    public void setDuanshipinName(String duanshipinName) {
        this.duanshipinName = duanshipinName;
    }
    /**
	 * 设置：短视频照片
	 */
    public String getDuanshipinPhoto() {
        return duanshipinPhoto;
    }


    /**
	 * 获取：短视频照片
	 */

    public void setDuanshipinPhoto(String duanshipinPhoto) {
        this.duanshipinPhoto = duanshipinPhoto;
    }
    /**
	 * 设置：短视频视频
	 */
    public String getDuanshipinVideo() {
        return duanshipinVideo;
    }


    /**
	 * 获取：短视频视频
	 */

    public void setDuanshipinVideo(String duanshipinVideo) {
        this.duanshipinVideo = duanshipinVideo;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：短视频类型
	 */
    public Integer getDuanshipinTypes() {
        return duanshipinTypes;
    }


    /**
	 * 获取：短视频类型
	 */

    public void setDuanshipinTypes(Integer duanshipinTypes) {
        this.duanshipinTypes = duanshipinTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getDuanshipinContent() {
        return duanshipinContent;
    }


    /**
	 * 获取：详情
	 */

    public void setDuanshipinContent(String duanshipinContent) {
        this.duanshipinContent = duanshipinContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDuanshipinDelete() {
        return duanshipinDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDuanshipinDelete(Integer duanshipinDelete) {
        this.duanshipinDelete = duanshipinDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
