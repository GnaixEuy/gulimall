package cn.fluorescent.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 18:05:14
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

