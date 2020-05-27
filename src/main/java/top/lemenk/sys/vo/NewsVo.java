package top.lemenk.sys.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import top.lemenk.sys.entity.News;

import java.util.Date;


/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/2 20:57
 * @Description :
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NewsVo extends News {

    private static final long serialVersionUID = -3835319414752751206L;
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 接收多个id
     */
    private Integer[] ids;
}
