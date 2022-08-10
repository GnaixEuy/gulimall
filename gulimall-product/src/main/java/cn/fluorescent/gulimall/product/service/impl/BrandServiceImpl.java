package cn.fluorescent.gulimall.product.service.impl;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.common.utils.Query;
import cn.fluorescent.gulimall.product.dao.BrandDao;
import cn.fluorescent.gulimall.product.entity.BrandEntity;
import cn.fluorescent.gulimall.product.service.BrandService;
import cn.fluorescent.gulimall.product.service.CategoryBrandRelationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //参数列表中拿关键字
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> brandEntityQueryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(key)) {
            brandEntityQueryWrapper.eq("brand_id", key).or().like("name", key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                brandEntityQueryWrapper
        );
        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void updateDetail(BrandEntity brand) {
        //保证冗余字段的数据一致
        this.updateById(brand);
        //如果brand中的name更改的话
        if (!org.springframework.util.StringUtils.isEmpty(brand.getName())) {
            //同步更新其他关联表中的数据
            categoryBrandRelationService.updateBrand(brand.getBrandId(), brand.getName());

            //TODO 更新其他关联
        }
    }

    @Autowired
    public void setCategoryBrandRelationService(CategoryBrandRelationService categoryBrandRelationService) {
        this.categoryBrandRelationService = categoryBrandRelationService;
    }
}