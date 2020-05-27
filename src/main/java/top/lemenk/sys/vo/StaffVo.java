package top.lemenk.sys.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.lemenk.sys.entity.Staff;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/1 13:30
 * @Description :Staff增强类
 */

@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
public class StaffVo extends Staff {

    private static final long serialVersionUID = 7004298658861522851L;

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
}
