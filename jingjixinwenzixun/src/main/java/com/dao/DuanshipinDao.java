package com.dao;

import com.entity.DuanshipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DuanshipinView;

/**
 * 短视频信息 Dao 接口
 *
 * @author 
 */
public interface DuanshipinDao extends BaseMapper<DuanshipinEntity> {

   List<DuanshipinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
