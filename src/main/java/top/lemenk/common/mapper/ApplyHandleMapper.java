package top.lemenk.common.mapper;

import top.lemenk.common.entity.ApplyHandle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lemenk.common.vo.ApplyHandleVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-11
 */
public interface ApplyHandleMapper extends BaseMapper<ApplyHandle> {

    /**
     * 通过教师的教师号查询当前教师所属学院的学生的申请信息
     * @param applyHandleVo
     * @return
     */
    List<ApplyHandleVo> queryApplyInfoByTechNo(ApplyHandleVo applyHandleVo);

    /**
     * 通过工作人员的编号查询所属部门下的学生的申请信息
     * @param applyHandleVo
     * @return
     */
    List<ApplyHandleVo> queryApplyInfoByStaNo(ApplyHandleVo applyHandleVo);

}
