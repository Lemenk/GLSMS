package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lemenk.sys.vo.StudentVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询所有学生的信息
     * @param student
     * @return
     */
    List<StudentVo> queryAllStudent(Student student);

    /**
     * 使用学生学号查询学生信息
     * @param stuNo
     * @return
     */
    Student studentInfo(String stuNo);

    /**
     * 使用学生学号删除学生表信息
     * @param stuNo
     * @return
     */
    int deleteByStuNo(String stuNo);

    /**
     * 添加学生信息到学生表
     * @param studentVo
     * @return
     */
    int insertStudentInfo(StudentVo studentVo);

}
