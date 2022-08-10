package cn.fluorescent.gulimall.product.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <img src="http://blog.gnaixeuy.cn/wp-content/uploads/2022/06/bug.png"/>
 *
 * <p>项目： gulimall </p>
 *
 * @author GnaixEuy
 * @date 2022/8/10
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */
@Configuration
@EnableTransactionManagement //开启事务
@MapperScan("cn.fluorescent.gulimall.product.dao")
public class MybatisPlusConfig {
    //引入分页插件
    @Bean
    public PaginationInnerInterceptor paginationInterceptor() {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(true);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setMaxLimit(1000L);
        return paginationInterceptor;
    }
}