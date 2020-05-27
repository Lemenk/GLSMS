package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lemenk.sys.vo.TeacherVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-30
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    /**
     * 查询所有教师的信息
     * @param teacher
     * @return
     */
    List<Teacher> queryAllTeacher(Teacher teacher);

    /**
     * 使用教师编号删除教师表信息
     * @param techId
     * @return
     */
    int deleteByTechId(String techId);

    /**
     * 添加教师信息到教师表
     * @param teacher
     * @return
     */
    int insertTeacherInfo(Teacher teacher);

    /**
     * 使用教师编号查询教师信息
     * @param techId
     * @return
     */
    Teacher teacherInfo(String techId);

}
