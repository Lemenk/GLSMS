package top.lemenk.sys.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.lemenk.sys.entity.Menu;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/4/22 12:59
 * @Description :
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Accessors(chain = true)
public class MenuVo extends Menu {

    private static final long serialVersionUID = -6437441340254119521L;
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
}
