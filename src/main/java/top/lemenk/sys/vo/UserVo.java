package top.lemenk.sys.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.lemenk.sys.entity.User;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/4/26 11:15
 * @Description : User实体类的增强类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserVo extends User {

    private static final long serialVersionUID = -6193079181412649157L;

    private String code;
}
