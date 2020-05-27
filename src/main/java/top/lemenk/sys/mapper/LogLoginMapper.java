package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.LogLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-02
 */
public interface LogLoginMapper extends BaseMapper<LogLogin> {

    /**
     * 查询所有登录日志
     * @param logLogin
     * @return
     */
    List<LogLogin> queryAllLogLogin(LogLogin logLogin);

}
