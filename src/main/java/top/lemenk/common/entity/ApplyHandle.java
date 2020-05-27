package top.lemenk.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comm_apply_handle")
public class ApplyHandle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * csp表的主键id
     */
    private Integer cspId;

    /**
     * 学生表序号
     */
    @TableField(exist = false)
    private Integer stuId;

    /**
     * 流程id
     */
    @TableField(exist = false)
    private Integer procId;

    /**
     * 学号
     */
    @TableField(exist = false)
    private String stuNo;

    /**
     * 姓名
     */
    @TableField(exist = false)
    private String stuName;

    /**
     * 学院
     */
    @TableField(exist = false)
    private String stuDept;

    /**
     * 班级
     */
    @TableField(exist = false)
    private String className;

    /**
     * 状态码。0未处理，1成功，2失败
     */
    private Integer status;

    /**
     * 状态名称
     */
    @TableField(exist = false)
    private String statusName;

    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(exist = false)
    private Date applyTime;

    /**
     * 处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(exist = false)
    private Date handleTime;

    /**
     * 处理人
     */
    @TableField(exist = false)
    private String handler;

    /**
     * 备注
     */
    private String remark;


}
