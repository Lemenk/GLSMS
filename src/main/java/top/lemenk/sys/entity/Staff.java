package top.lemenk.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 工作人员实体类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 工作人员ID
     */
    @TableField("staId")
    private String staId;

    /**
     * 工作人员名称
     */
    @TableField("staName")
    private String staName;

    /**
     * 工作人员所属部门
     */
    private String staDept;

    /**
     *部门名称
     */
    @TableField(exist = false)
    private String deptName;


    /**
     * 邮箱
     */
    private String email;


}
