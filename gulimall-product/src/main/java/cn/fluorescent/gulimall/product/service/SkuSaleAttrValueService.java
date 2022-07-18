package cn.fluorescent.gulimall.product.service;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.product.entity.SkuSaleAttrValueEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 17:27:17
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

