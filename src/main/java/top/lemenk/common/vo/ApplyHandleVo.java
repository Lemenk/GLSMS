package top.lemenk.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.lemenk.common.entity.ApplyHandle;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/8 0:13
 * @Description :
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ApplyHandleVo extends ApplyHandle {
    private static final long serialVersionUID = -4024979592098343932L;

    /**
     * 教师编号
     */
    @TableField(exist = false)
    private String techNo;

    /**
     * 工作人员编号
     */
    @TableField(exist = false)
    private String staffNo;
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
}
