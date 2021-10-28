package com.zyc.mp.service.impl;

import com.zyc.mp.entity.OperationLogEntity;
import com.zyc.mp.dao.OperationLogMapper;
import com.zyc.mp.service.OperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author yachao.zhang
 * @since 2021-01-03
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLogEntity> implements OperationLogService {

}
