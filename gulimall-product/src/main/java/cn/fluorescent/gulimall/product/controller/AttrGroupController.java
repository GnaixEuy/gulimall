package cn.fluorescent.gulimall.product.controller;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.common.utils.R;
import cn.fluorescent.gulimall.product.entity.AttrGroupEntity;
import cn.fluorescent.gulimall.product.service.AttrGroupService;
import cn.fluorescent.gulimall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 属性分组
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 17:27:18
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    private AttrGroupService attrGroupService;
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrGroupService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表 传一个三级目录id查出其下的数据
     */
    @RequestMapping("/list/{catelogId}")
    //接受一个map 的 参数params 和catelogId
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable("catelogId") Long catelogId) {

        //调用service层方法
        PageUtils page = attrGroupService.queryPage(params, catelogId);

        return R.ok().put("page", page);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds) {
        attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId) {
        //根据attrGroupId查出对应的实体类
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

        //从实体类中获取catelogId
        Long catelogId = attrGroup.getCatelogId();
        //调用categoryService categoryService 查出 路径
        Long[] path = categoryService.findCatelogPath(catelogId);
        //把路径设置到其中 返回给前端
        attrGroup.setCatelogPath(path);


        return R.ok().put("attrGroup", attrGroup);
    }

    @Autowired
    public void setAttrGroupService(AttrGroupService attrGroupService) {
        this.attrGroupService = attrGroupService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
