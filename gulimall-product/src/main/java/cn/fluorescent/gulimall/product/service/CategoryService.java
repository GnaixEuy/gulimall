package cn.fluorescent.gulimall.product.service;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 17:27:18
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    Long[] findCatelogPath(Long catelogId);
}

