package cn.fluorescent.gulimall.order.dao;

import cn.fluorescent.gulimall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 18:38:19
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
