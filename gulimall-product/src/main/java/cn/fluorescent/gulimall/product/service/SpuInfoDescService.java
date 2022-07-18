package cn.fluorescent.gulimall.product.service;

import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.product.entity.SpuInfoDescEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 17:27:18
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

