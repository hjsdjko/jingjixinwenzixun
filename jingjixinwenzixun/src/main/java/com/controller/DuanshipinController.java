
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 短视频信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/duanshipin")
public class DuanshipinController {
    private static final Logger logger = LoggerFactory.getLogger(DuanshipinController.class);

    private static final String TABLE_NAME = "duanshipin";

    @Autowired
    private DuanshipinService duanshipinService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private DuanshipinCollectionService duanshipinCollectionService;//短视频收藏
    @Autowired
    private DuanshipinLiuyanService duanshipinLiuyanService;//短视频留言
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private NewsService newsService;//新闻信息
    @Autowired
    private NewsCollectionService newsCollectionService;//新闻收藏
    @Autowired
    private NewsLiuyanService newsLiuyanService;//新闻留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("duanshipinDeleteStart",1);params.put("duanshipinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = duanshipinService.queryPage(params);

        //字典表数据转换
        List<DuanshipinView> list =(List<DuanshipinView>)page.getList();
        for(DuanshipinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DuanshipinEntity duanshipin = duanshipinService.selectById(id);
        if(duanshipin !=null){
            //entity转view
            DuanshipinView view = new DuanshipinView();
            BeanUtils.copyProperties( duanshipin , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DuanshipinEntity duanshipin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,duanshipin:{}",this.getClass().getName(),duanshipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DuanshipinEntity> queryWrapper = new EntityWrapper<DuanshipinEntity>()
            .eq("duanshipin_name", duanshipin.getDuanshipinName())
            .eq("duanshipin_video", duanshipin.getDuanshipinVideo())
            .eq("zan_number", duanshipin.getZanNumber())
            .eq("cai_number", duanshipin.getCaiNumber())
            .eq("duanshipin_types", duanshipin.getDuanshipinTypes())
            .eq("duanshipin_delete", duanshipin.getDuanshipinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DuanshipinEntity duanshipinEntity = duanshipinService.selectOne(queryWrapper);
        if(duanshipinEntity==null){
            duanshipin.setDuanshipinDelete(1);
            duanshipin.setInsertTime(new Date());
            duanshipin.setCreateTime(new Date());
            duanshipinService.insert(duanshipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DuanshipinEntity duanshipin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,duanshipin:{}",this.getClass().getName(),duanshipin.toString());
        DuanshipinEntity oldDuanshipinEntity = duanshipinService.selectById(duanshipin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(duanshipin.getDuanshipinPhoto()) || "null".equals(duanshipin.getDuanshipinPhoto())){
                duanshipin.setDuanshipinPhoto(null);
        }
        if("".equals(duanshipin.getDuanshipinVideo()) || "null".equals(duanshipin.getDuanshipinVideo())){
                duanshipin.setDuanshipinVideo(null);
        }

            duanshipinService.updateById(duanshipin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DuanshipinEntity> oldDuanshipinList =duanshipinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DuanshipinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DuanshipinEntity duanshipinEntity = new DuanshipinEntity();
            duanshipinEntity.setId(id);
            duanshipinEntity.setDuanshipinDelete(2);
            list.add(duanshipinEntity);
        }
        if(list != null && list.size() >0){
            duanshipinService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DuanshipinEntity> duanshipinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DuanshipinEntity duanshipinEntity = new DuanshipinEntity();
//                            duanshipinEntity.setDuanshipinName(data.get(0));                    //短视频名称 要改的
//                            duanshipinEntity.setDuanshipinPhoto("");//详情和图片
//                            duanshipinEntity.setDuanshipinVideo(data.get(0));                    //短视频视频 要改的
//                            duanshipinEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            duanshipinEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            duanshipinEntity.setDuanshipinTypes(Integer.valueOf(data.get(0)));   //短视频类型 要改的
//                            duanshipinEntity.setDuanshipinContent("");//详情和图片
//                            duanshipinEntity.setDuanshipinDelete(1);//逻辑删除字段
//                            duanshipinEntity.setInsertTime(date);//时间
//                            duanshipinEntity.setCreateTime(date);//时间
                            duanshipinList.add(duanshipinEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        duanshipinService.insertBatch(duanshipinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<DuanshipinView> returnDuanshipinViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = duanshipinCollectionService.queryPage(params1);
        List<DuanshipinCollectionView> collectionViewsList =(List<DuanshipinCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(DuanshipinCollectionView collectionView:collectionViewsList){
            Integer duanshipinTypes = collectionView.getDuanshipinTypes();
            if(typeMap.containsKey(duanshipinTypes)){
                typeMap.put(duanshipinTypes,typeMap.get(duanshipinTypes)+1);
            }else{
                typeMap.put(duanshipinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("duanshipinTypes",type);
            PageUtils pageUtils1 = duanshipinService.queryPage(params2);
            List<DuanshipinView> duanshipinViewList =(List<DuanshipinView>)pageUtils1.getList();
            returnDuanshipinViewList.addAll(duanshipinViewList);
            if(returnDuanshipinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = duanshipinService.queryPage(params);
        if(returnDuanshipinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnDuanshipinViewList.size();//要添加的数量
            List<DuanshipinView> duanshipinViewList =(List<DuanshipinView>)page.getList();
            for(DuanshipinView duanshipinView:duanshipinViewList){
                Boolean addFlag = true;
                for(DuanshipinView returnDuanshipinView:returnDuanshipinViewList){
                    if(returnDuanshipinView.getId().intValue() ==duanshipinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnDuanshipinViewList.add(duanshipinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnDuanshipinViewList = returnDuanshipinViewList.subList(0, limit);
        }

        for(DuanshipinView c:returnDuanshipinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnDuanshipinViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = duanshipinService.queryPage(params);

        //字典表数据转换
        List<DuanshipinView> list =(List<DuanshipinView>)page.getList();
        for(DuanshipinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DuanshipinEntity duanshipin = duanshipinService.selectById(id);
            if(duanshipin !=null){


                //entity转view
                DuanshipinView view = new DuanshipinView();
                BeanUtils.copyProperties( duanshipin , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody DuanshipinEntity duanshipin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,duanshipin:{}",this.getClass().getName(),duanshipin.toString());
        Wrapper<DuanshipinEntity> queryWrapper = new EntityWrapper<DuanshipinEntity>()
            .eq("duanshipin_name", duanshipin.getDuanshipinName())
            .eq("duanshipin_video", duanshipin.getDuanshipinVideo())
            .eq("zan_number", duanshipin.getZanNumber())
            .eq("cai_number", duanshipin.getCaiNumber())
            .eq("duanshipin_types", duanshipin.getDuanshipinTypes())
            .eq("duanshipin_delete", duanshipin.getDuanshipinDelete())
//            .notIn("duanshipin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DuanshipinEntity duanshipinEntity = duanshipinService.selectOne(queryWrapper);
        if(duanshipinEntity==null){
                duanshipin.setZanNumber(1);
                duanshipin.setCaiNumber(1);
            duanshipin.setDuanshipinDelete(1);
            duanshipin.setInsertTime(new Date());
            duanshipin.setCreateTime(new Date());
        duanshipinService.insert(duanshipin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

