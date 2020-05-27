package top.lemenk.sys.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.lemenk.sys.entity.Teacher;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/4/30 17:39
 * @Description : Teacher增强类
 */

@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
public class TeacherVo extends Teacher {

    private static final long serialVersionUID = 8115983263429154399L;
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
}
