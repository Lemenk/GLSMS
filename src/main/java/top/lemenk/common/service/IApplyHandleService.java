package top.lemenk.common.service;

import top.lemenk.common.entity.ApplyHandle;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.common.vo.ApplyHandleVo;
import top.lemenk.sys.utils.DataGridView;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-11
 */
public interface IApplyHandleService extends IService<ApplyHandle> {

    /**
     * 向comm_apply_handle表添加申请信息
     * @param applyHandleVo
     * @return
     */
    int insertApplyInfo(ApplyHandleVo applyHandleVo);

    /**
     * 更新申请处理表
     * @param applyHandleVo
     * @return
     */
    int updateApplyHandle(ApplyHandleVo applyHandleVo);

    /**
     * 通过教师的教师号查询当前教师所属学院的学生的申请信息
     * @param applyHandleVo
     * @return
     */
    DataGridView queryApplyInfoByTechNo(ApplyHandleVo applyHandleVo);

    /**
     * 通过教师的教师号查询当前教师所属学院的学生的申请信息
     * @param applyHandleVo
     * @return
     */
    DataGridView queryApplyInfoByStaNo(ApplyHandleVo applyHandleVo);

    /**
     * 通过id查询申请信息
     * @param id
     * @return
     */
    ApplyHandle queryApplyHandleById(Integer id);

}
