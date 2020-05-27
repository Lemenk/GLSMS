package top.lemenk.sys.service;

import top.lemenk.sys.entity.LogLogin;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.LogLoginVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-02
 */
public interface ILogLoginService extends IService<LogLogin> {

    /**
     * 查询所有日志
     * @param logLoginVo
     * @return
     */
    DataGridView queryAllLogLogin(LogLoginVo logLoginVo);

    /**
     * 添加日志
     * @param logLoginVo
     */
    void addLogLogin(LogLoginVo logLoginVo);

    /**
     * 根据id删除日志
     * @param logLoginId
     */
    void deleteLogLogin(Integer logLoginId);

    /**
     * 批量删除日志
     * @param id
     */
    void deleteBatchLogLogin(Integer[] id);

}
