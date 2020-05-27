package top.lemenk.sys.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.lemenk.sys.entity.Student;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/4/27 20:14
 * @Description : 学生实体类的增强类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentVo extends Student {

    private static final long serialVersionUID = -1604153569559535175L;
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
     * 学院编号
     */
    @TableField("stu_dept")
    private String stuDept;

    /**
     * 学院名称
     */
    private String deptName;

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

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;



}
