package cn.fluorescent.gulimall.product.service.impl;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.common.utils.Query;
import cn.fluorescent.gulimall.product.dao.AttrGroupDao;
import cn.fluorescent.gulimall.product.entity.AttrGroupEntity;
import cn.fluorescent.gulimall.product.service.AttrGroupService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        //1 首先拿到传过来参数中的key对应的参数
        String key = (String) params.get("key");
        //select * from pms_attr_group where catelog_id=? and (attr_group_id=key or attr_group_name like %key%)

        //2 创造一个对应实体类的queryWrapper
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();

        //3 如果key关键字对应的不为空的话
        if (!StringUtils.isEmpty(key)) {
            //要满足and (attr_group_id=key or attr_group_name like %key%)
            wrapper.and((obj) -> {
                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
            });
        }

        //4 如果传来的catelogId为0
        if (catelogId == 0) {

            //直接根据params和wrapper生成page
            //Query utils不过是把params 变为 page
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);

            //把Ipage对象通过PageUtils进行处理 处理成我们自定义的字段返回给前端
            return new PageUtils(page);
        } else {

            // 5 如果传来的cateLogId不为0 wrapper再次匹配这个字段
            //Query utils不过是把params 变为 page
            wrapper.eq("catelog_id", catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            //把Ipage对象通过PageUtils进行处理 处理成我们自定义的字段返回给前端
            return new PageUtils(page);
        }
    }

}