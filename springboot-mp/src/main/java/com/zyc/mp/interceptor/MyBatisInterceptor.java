package com.zyc.mp.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author yachao.zhang
 * @description //TODO
 * @createTime  2021/2/3 15:37
 **/
@Intercepts(@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}))
@Slf4j
public class MyBatisInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation){
        try {
            StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
            String sql = statementHandler.getBoundSql().getSql();
            MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
            log.info("拦截到的sql:{}",sql);
            return invocation.proceed();
        } catch (Exception e) {
            log.info("chucuo");
            //e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
