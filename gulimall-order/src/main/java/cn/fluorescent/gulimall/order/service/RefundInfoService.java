package cn.fluorescent.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.order.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 18:38:19
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

