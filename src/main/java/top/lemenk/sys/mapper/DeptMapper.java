package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lemenk.sys.entity.Student;
import top.lemenk.sys.vo.DeptVo;
import top.lemenk.sys.vo.StudentVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-28
 */
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 查询所有学生的信息
     * @param dept
     * @return
     */
    List<DeptVo> queryAllDept(Dept dept);
    /**
     * 查询所有后勤管理部门
     * @param dept
     * @return
     */
    List<Dept> queryStaDept(Dept dept);

    /**
     * 查询所有的学院
     * @param dept
     * @return
     */
    List<Dept> queryColDept(Dept dept);

    /**
     * 根据部门id查询部门信息
     * @param deptId
     * @return
     */
    Dept queryDeptByDeptId(String deptId);

    /**
     * 查询最后一行
     * @return
     */
    Dept queryLastRow();

}
