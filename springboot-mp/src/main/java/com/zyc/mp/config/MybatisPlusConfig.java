package com.zyc.mp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.zyc.mp.interceptor.MyBatisInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author yachao.zhang
 * @description MybatisPlusConfig配置类
 * @createTime  2021/1/2 17:43
 **/
@Configuration
public class MybatisPlusConfig {

    /**
     * 新的插件配置
     * PaginationInnerInterceptor分页一缓和二缓遵循mybatis的规则 PaginationInnerInterceptor
     */
    @Bean
    @Order(1)
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 配置分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        paginationInnerInterceptor.setOverflow(true);
        paginationInnerInterceptor.setMaxLimit(1000L);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }

    //@Bean
    public MyBatisInterceptor getMyBatisInterceptor(){
        return new MyBatisInterceptor();
    }


}
