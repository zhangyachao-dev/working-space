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
 * 字典表	
 * </p>
 *
 * @author yachao.zhang
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dictionary")
public class DictionaryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * rid
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 字典码
     */
    private String code;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 附加字段1
     */
    private String attach1;

    /**
     * 附加字段2
     */
    private String attach2;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除  0:未删除 1:已删除
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
