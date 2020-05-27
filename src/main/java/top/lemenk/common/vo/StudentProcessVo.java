package top.lemenk.common.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.lemenk.common.entity.StudentProcess;

import java.util.Date;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/7 14:09
 * @Description :
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StudentProcessVo extends StudentProcess {
    private static final long serialVersionUID = -4395781444515754476L;

    //id,proc_name,status,handler,handle_time

    private Integer id;
    private String procName;
    private Integer status;

    @TableField(exist = false)
    private String statusName;

    private String handler;
    /**
     * 办理时间
     */
    private Date handleTime;
}
