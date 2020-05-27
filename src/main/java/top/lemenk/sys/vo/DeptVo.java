package top.lemenk.sys.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.lemenk.sys.entity.Dept;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/12 21:24
 * @Description :
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeptVo extends Dept {
    private static final long serialVersionUID = 8409719591484473947L;

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

}
