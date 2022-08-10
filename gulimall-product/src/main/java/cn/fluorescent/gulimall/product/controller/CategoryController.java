package cn.fluorescent.gulimall.product.controller;

import cn.fluorescent.gulimall.common.utils.R;
import cn.fluorescent.gulimall.product.entity.CategoryBrandRelationEntity;
import cn.fluorescent.gulimall.product.entity.CategoryEntity;
import cn.fluorescent.gulimall.product.service.CategoryBrandRelationService;
import cn.fluorescent.gulimall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 商品三级分类
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 17:27:18
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    private CategoryService categoryService;
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 列表
     */
    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    // @RequiresPermissions("product:category:list")
    public R list(@RequestParam Map<String, Object> params) {
        List<CategoryEntity> entities = categoryService.listWithTree();

        return R.ok().put("data", entities);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    // @RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {
        categoryBrandRelationService.saveDetail(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 修改分类
     */
    @RequestMapping("/update/sort")
    // @RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity[] category) {

        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }


    /**
     * 删除
     * <p>
     * &#064;RequestBody  获取请求体，必须发送POST请求
     * SpringMVC自动将请求体的数据(json),转为对应的对象
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds) {

        categoryService.removeMenuByIds(Arrays.asList(catIds));
        return R.ok();
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setCategoryBrandRelationService(CategoryBrandRelationService categoryBrandRelationService) {
        this.categoryBrandRelationService = categoryBrandRelationService;
    }
}
