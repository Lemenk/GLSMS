package top.lemenk.common.service;

import top.lemenk.common.entity.StudentProcess;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.common.vo.ApplyHandleVo;
import top.lemenk.common.vo.StudentProcessVo;
import top.lemenk.sys.utils.DataGridView;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-07
 */
public interface IStudentProcessService extends IService<StudentProcess> {

    /**
     * 通过学生表id查询是否是第一次登陆
     * @param stuId
     * @return
     */
    void checkYesOrNoFirstLogin(Integer stuId);

    /**
     * 学生第一次登录后，向数据库中插入5条流程
     * @param studentProcessVo
     * @return
     */
    int insertStudentProcess(StudentProcessVo studentProcessVo);

    /**
     * 根据当前登录学生的id查询流程状态
     * @param stuId
     * @return
     */
    DataGridView queryStudentProcessByStuId(Integer stuId);

    /**
     * 更新流程数据表
     * @param studentProcessVo
     * @return
     */
    int updateStudentProcess(StudentProcessVo studentProcessVo);

    /**
     * 通过id查询申请信息
     * @param id
     * @return
     */
    StudentProcess queryStudentProcessById(Integer id);
}
