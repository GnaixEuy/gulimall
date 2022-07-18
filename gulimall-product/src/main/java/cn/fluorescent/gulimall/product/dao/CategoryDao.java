package cn.fluorescent.gulimall.product.dao;

import cn.fluorescent.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 17:27:18
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
