package cn.fluorescent.gulimall.product.service.impl;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.common.utils.Query;
import cn.fluorescent.gulimall.product.dao.BrandDao;
import cn.fluorescent.gulimall.product.dao.CategoryBrandRelationDao;
import cn.fluorescent.gulimall.product.dao.CategoryDao;
import cn.fluorescent.gulimall.product.entity.BrandEntity;
import cn.fluorescent.gulimall.product.entity.CategoryBrandRelationEntity;
import cn.fluorescent.gulimall.product.entity.CategoryEntity;
import cn.fluorescent.gulimall.product.service.CategoryBrandRelationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    private BrandDao brandDao;
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveDetail(CategoryBrandRelationEntity categoryBrandRelation) {
        Long brandId = categoryBrandRelation.getBrandId();
        Long catelogId = categoryBrandRelation.getCatelogId();
        //1、查询详细名字
        BrandEntity brandEntity = brandDao.selectById(brandId);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        categoryBrandRelation.setBrandName(brandEntity.getName());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());
        this.save(categoryBrandRelation);
    }

    @Override
    public void updateBrand(Long brandId, String name) {
        //创建一个新的关系实体类
        CategoryBrandRelationEntity relationEntity = new CategoryBrandRelationEntity();
        //设置ID和name为我们传来的
        relationEntity.setBrandId(brandId);
        relationEntity.setBrandName(name);
        //更新ID为xxx的name字段完成级联更新
        this.update(relationEntity, new UpdateWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId));
    }

    @Autowired
    public void setBrandDao(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
}