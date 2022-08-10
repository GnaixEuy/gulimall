package cn.fluorescent.gulimall.product.service.impl;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.common.utils.Query;
import cn.fluorescent.gulimall.product.dao.CategoryDao;
import cn.fluorescent.gulimall.product.entity.CategoryEntity;
import cn.fluorescent.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1 查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        // 2 组装成父子的树形结构
        return entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).peek((menu) -> menu.setChildren(getChildrens(menu, entities))).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());
    }


    @Override
    public void removeMenuByIds(List<Long> asList) {
        // TODO 1 检查当前删除的菜单，是否被别的地方引用

        // 逻辑删除
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * 找到一个三级目录对应的完整路径 [2,25,225]  /电器/好电器/手机
     */

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        //新建一个ArrayList集合 接受Long
        List<Long> paths = new ArrayList<>();

        //调用方法找到完整路径[225，22，2]
        List<Long> parentPath = findParentPath(catelogId, paths);

        //调用逆序方法获得正确顺序[2,25,225]
        Collections.reverse(parentPath);


        return parentPath.toArray(new Long[parentPath.size()]);
    }

    /**
     * 找到一个三级目录对应的完整路径 [2,25,225]  /电器/好电器/手机
     */
    private List<Long> findParentPath(Long catelogId, List<Long> paths) {
        //1、收集当前节点id
        paths.add(catelogId);
        //2 根据当前节点ID拿到其对应的实体类
        CategoryEntity byId = this.getById(catelogId);
        //3 当实体类父id不为0继续调用这个方法
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }
        //4 跳出递归循环返回数据
        return paths;

    }


    // 递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().longValue() == root.getCatId().longValue();  // 注意此处应该用longValue()来比较，否则会出先bug，因为parentCid和catId是long类型
        }).peek(categoryEntity -> {
            // 1 找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
        }).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());
    }

}