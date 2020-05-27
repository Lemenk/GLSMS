package top.lemenk.common.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.lemenk.common.constant.SysConstant;
import top.lemenk.common.entity.ApplyHandle;
import top.lemenk.common.mapper.ApplyHandleMapper;
import top.lemenk.common.service.IApplyHandleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.common.vo.ApplyHandleVo;
import top.lemenk.sys.utils.DataGridView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-11
 */
@Service
public class ApplyHandleServiceImpl extends ServiceImpl<ApplyHandleMapper, ApplyHandle> implements IApplyHandleService {

    @Resource
    private ApplyHandleMapper applyHandleMapper;

    @Override
    public int insertApplyInfo(ApplyHandleVo applyHandleVo) {
        applyHandleVo.setStatus(SysConstant.HANDLE_NO);
        return this.applyHandleMapper.insert(applyHandleVo);
    }

    @Override
    public int updateApplyHandle(ApplyHandleVo applyHandleVo) {
        return this.applyHandleMapper.updateById(applyHandleVo);
    }

    @Override
    public DataGridView queryApplyInfoByTechNo(ApplyHandleVo applyHandleVo) {
        Page<Object> page = PageHelper.startPage(applyHandleVo.getPage(), applyHandleVo.getLimit());
        List<ApplyHandleVo> data = this.applyHandleMapper.queryApplyInfoByTechNo(applyHandleVo);
        for (ApplyHandle ah : data) {
            switch (ah.getStatus()) {
                case 1:
                    ah.setStatusName(SysConstant.HANDLE_INFO_TRUE);
                    break;
                case 2:
                    ah.setStatusName(SysConstant.APPLIED_INFO_FALSE);
                    break;
                default:
                    ah.setStatusName(SysConstant.HANDLE_INFO_NO);
            }
        }
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public DataGridView queryApplyInfoByStaNo(ApplyHandleVo applyHandleVo) {
        Page<Object> page = PageHelper.startPage(applyHandleVo.getPage(), applyHandleVo.getLimit());
        List<ApplyHandleVo> data = this.applyHandleMapper.queryApplyInfoByStaNo(applyHandleVo);
        for (ApplyHandle ah : data) {
            switch (ah.getStatus()) {
                case 1:
                    ah.setStatusName(SysConstant.HANDLE_INFO_TRUE);
                    break;
                case 2:
                    ah.setStatusName(SysConstant.APPLIED_INFO_FALSE);
                    break;
                default:
                    ah.setStatusName(SysConstant.HANDLE_INFO_NO);
            }
        }
        return new DataGridView(page.getTotal(),data);
    }

    @Override
    public ApplyHandle queryApplyHandleById(Integer id) {
        return this.applyHandleMapper.selectById(id);
    }
}
