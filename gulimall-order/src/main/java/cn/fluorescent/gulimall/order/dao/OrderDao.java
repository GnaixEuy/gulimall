package cn.fluorescent.gulimall.order.dao;

import cn.fluorescent.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author GnaixEuy
 * @email sgghcj@live.com
 * @date 2022-07-18 18:38:19
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
