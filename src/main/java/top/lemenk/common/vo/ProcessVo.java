package top.lemenk.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import top.lemenk.common.entity.Process;


/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/6 11:48
 * @Description :
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProcessVo extends Process {
    private static final long serialVersionUID = 2759535000040898511L;

    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
}
