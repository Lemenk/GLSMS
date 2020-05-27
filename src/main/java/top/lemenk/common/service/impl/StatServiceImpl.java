package top.lemenk.common.service.impl;

import org.springframework.stereotype.Service;
import top.lemenk.common.constant.SysConstant;
import top.lemenk.common.entity.BaseEntity;
import top.lemenk.common.mapper.StatMapper;
import top.lemenk.common.service.IStatService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/13 12:22
 * @Description :
 */

@Service
public class StatServiceImpl implements IStatService {

    @Resource
    private StatMapper statMapper;

    @Override
    public List<BaseEntity> loadApplyStat() {
        List<BaseEntity> list = this.statMapper.queryApply();
        for (BaseEntity b: list) {
            switch (b.getName()){
                case "0":
                    b.setName(SysConstant.APPLIED_INFO_NOT);
                    break;
                case "1":
                    b.setName(SysConstant.APPLIED_INFO_WAITING);
                    break;
                case "2":
                    b.setName(SysConstant.APPLIED_INFO_TRUE);
                    break;
                default:
                    b.setName(SysConstant.APPLIED_INFO_FALSE);
            }
        }
        return this.statMapper.queryApply();
    }

    @Override
    public List<BaseEntity> loadHandleStat() {
        List<BaseEntity> baseEntities = this.statMapper.queryHandle();
        for (BaseEntity be: baseEntities) {
            switch (be.getName()){
                case "0":
                    be.setName(SysConstant.HANDLE_INFO_NO);
                    break;
                case "1":
                    be.setName(SysConstant.HANDLE_INFO_TRUE);
                    break;
                default:
                    be.setName(SysConstant.HANDLE_INFO_FALSE);
            }
        }
        return this.statMapper.queryHandle();
    }
}
