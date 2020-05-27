package top.lemenk.sys.service;

import top.lemenk.sys.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.StudentVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
public interface IStudentService extends IService<Student> {

    /**
     * 查询所有学生
     * @param studentVo
     * @return
     */
    public DataGridView queryAllStudent(StudentVo studentVo);

    /**
     * 添加学生
     * @param studentVo
     */
    public void addStudent(StudentVo studentVo);

    /**
     * 修改学生
     * @param studentVo
     */
    public void updateStudent(StudentVo studentVo);

    /**
     * 根据stuId删除学生
     * @param stuNo
     */
    public void deleteStudent(String stuNo);


    /**
     * 重置密码
     * @param stuNo
     */
    public void resetUserPwd(String stuNo);



    /**
     * 使用学生学号查询学生信息
     * @param stuNo
     * @return
     */
    Student studentInfo(String stuNo);

}
