package top.lemenk.common.mapper;

import top.lemenk.common.entity.StudentProcess;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-07
 */
public interface StudentProcessMapper extends BaseMapper<StudentProcess> {

    /**
     * 通过学生表id查询是否是第一次登陆
     * @param stuId
     * @return
     */
    String selectYesOrNoFirstLogin(Integer stuId);


    /**
     * 根据当前登录学生的id查询流程状态
     * @param stuId
     * @return
     */
    List<StudentProcess> queryStudentProcessByStuId(Integer stuId);


}
