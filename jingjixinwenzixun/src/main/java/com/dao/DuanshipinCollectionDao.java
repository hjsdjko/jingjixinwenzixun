package com.dao;

import com.entity.DuanshipinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DuanshipinCollectionView;

/**
 * 短视频收藏 Dao 接口
 *
 * @author 
 */
public interface DuanshipinCollectionDao extends BaseMapper<DuanshipinCollectionEntity> {

   List<DuanshipinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
