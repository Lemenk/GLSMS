package top.lemenk.sys.service;

import top.lemenk.sys.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.TeacherVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-30
 */
public interface ITeacherService extends IService<Teacher> {

    /**
     * 查询所有教师
     * @param teacherVo
     * @return
     */
    DataGridView queryAllTeacher(TeacherVo teacherVo);

    /**
     * 添加教师
     * @param teacher
     */
    public void addTeacher(Teacher teacher);

    /**
     * 修改教师
     * @param teacherVo
     */
    public void updateTeacher(TeacherVo teacherVo);

    /**
     * 根据教师编号techId删除教师
     * @param techId
     */
    public void deleteTeacher(String techId);


    /**
     * 重置密码
     * @param techId
     */
    public void resetUserPwd(String techId);


    /**
     * 使用教师编号查询教师信息
     * @param techId
     * @return
     */
    Teacher teacherInfo(String techId);

}
