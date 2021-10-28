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
 * 权限表
 * </p>
 *
 * @author yachao.zhang
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("permission")
public class PermissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 父级id 用于展示作用 最顶级默认为0
     */
    private Long parentId;

    /**
     * 权限展示名称
     */
    private String label;

    /**
     * 后台权限控制使用的名称
     */
    private String code;

    /**
     * 图标
     */
    private String icon;

    /**
     * 访问时的url
     */
    private String url;

    /**
     * 是否显示 用于页面是否在菜单中显示
     */
    private Boolean display;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否为内置权限
     */
    private Boolean initial;

    /**
     * 是否启用 1 启用 0 禁用
     */
    private Boolean enable;

    /**
     * 页面类型 ,菜单类型 还是接口类型 还是按钮类型 控制显隐和访问	page	menu	button	api
     */
    private String type;

    /**
     * 是否删除 0未删除 1 已删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    private Long updateId;


}
