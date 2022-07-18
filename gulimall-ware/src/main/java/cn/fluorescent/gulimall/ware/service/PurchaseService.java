package cn.fluorescent.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.fluorescent.gulimall.common.utils.PageUtils;
import cn.fluorescent.gulimall.ware.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 18:42:29
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

