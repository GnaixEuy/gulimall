package cn.fluorescent.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 18:05:14
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

