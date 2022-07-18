package cn.fluorescent.gulimall.product.service;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.product.entity.SkuImagesEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * sku图片
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 17:27:18
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

