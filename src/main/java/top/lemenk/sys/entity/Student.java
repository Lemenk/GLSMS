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
 * 学生实体类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学号
     */
    @TableField("stu_no")
    private String stuNo;

    /**
     * 姓名
     */
    @TableField("stu_name")
    private String stuName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 学院
     */
    @TableField("stu_dept")
    private String stuDept;

    /**
     * 班级
     */
    @TableField("class_name")
    private String className;

    /**
     * 家庭住址
     */
    @TableField("home_address")
    private String homeAddress;


}
