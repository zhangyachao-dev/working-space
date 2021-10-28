package com.zyc.mp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author yachao.zhang
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("operation_log")
public class OperationLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 操作模块
     */
    private String module;

    /**
     * 操作类型
     */
    private String type;

    /**
     * 操作描述
     */
    private String descc;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 返回结果
     */
    private String respContent;

    /**
     * 请求用户ID
     */
    private Long userId;

    /**
     * 请求用户名称
     */
    private String userName;

    /**
     * 请求IP
     */
    private String ip;

    /**
     * 请求URI
     */
    private String uri;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
