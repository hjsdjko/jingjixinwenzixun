package com.dao;

import com.entity.DuanshipinLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DuanshipinLiuyanView;

/**
 * 短视频留言 Dao 接口
 *
 * @author 
 */
public interface DuanshipinLiuyanDao extends BaseMapper<DuanshipinLiuyanEntity> {

   List<DuanshipinLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
