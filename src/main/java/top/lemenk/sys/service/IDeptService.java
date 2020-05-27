package top.lemenk.sys.service;

import top.lemenk.sys.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.DeptVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-28
 */
public interface IDeptService extends IService<Dept> {


    /**
     * 查询所有部门
     * @param deptVo
     * @return
     */
    DataGridView queryAllDept(DeptVo deptVo);

    /**
     * 查询所有部门
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
     * 删除部门
     * @param id
     * @return
     */
    int deleteDept(Integer id);

    /**
     * 更新部门
     * @param deptVo
     * @return
     */
    int updateDept(DeptVo deptVo);

    /**
     * 添加学生
     * @param deptVo
     * @return
     */
    int addDept(DeptVo deptVo);

    /**
     * 查询最后一行
     * @return
     */
    Dept queryLastRow();
}
