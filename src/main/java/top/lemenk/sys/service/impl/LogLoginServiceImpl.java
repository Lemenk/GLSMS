package top.lemenk.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.lemenk.sys.entity.LogLogin;
import top.lemenk.sys.entity.Teacher;
import top.lemenk.sys.mapper.LogLoginMapper;
import top.lemenk.sys.service.ILogLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.LogLoginVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-02
 */
@Service
public class LogLoginServiceImpl extends ServiceImpl<LogLoginMapper, LogLogin> implements ILogLoginService {

    @Resource
    private LogLoginMapper logLoginMapper;

    @Override
    public DataGridView queryAllLogLogin(LogLoginVo logLoginVo) {
        Page<Object> page = PageHelper.startPage(logLoginVo.getPage(), logLoginVo.getLimit());
        List<LogLogin> data = this.logLoginMapper.queryAllLogLogin(logLoginVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addLogLogin(LogLoginVo logLoginVo) {
        this.logLoginMapper.insert(logLoginVo);
    }

    @Override
    public void deleteLogLogin(Integer logLoginId) {
        this.logLoginMapper.deleteById(logLoginId);
    }

    @Override
    public void deleteBatchLogLogin(Integer[] ids) {
        for (Integer i : ids) {
            this.deleteLogLogin(i);
        }
    }
}
