package top.lemenk.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import top.lemenk.sys.entity.Dept;
import top.lemenk.sys.service.IDeptService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.utils.ResultObj;
import top.lemenk.sys.utils.WebUtils;
import top.lemenk.sys.vo.DeptVo;
import top.lemenk.sys.vo.StudentVo;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-28
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Resource
    private IDeptService deptService;

    @RequestMapping("loadAllDept")
    public DataGridView loadAllDept(DeptVo deptVo) {
        return this.deptService.queryAllDept(deptVo);
    }

    @RequestMapping("loadColDept")
    public DataGridView loadColDept(Dept dept){
        List<Dept> depts = deptService.queryColDept(dept);
        return new DataGridView(0L,depts);
    }

    @RequestMapping("loadStaDept")
    public DataGridView loadStaDept(Dept dept){
        List<Dept> depts = deptService.queryStaDept(dept);
        return new DataGridView(0L,depts);
    }

    /**
     * 删除学生
     */
    @RequestMapping("deleteDept")
    public ResultObj deleteDept(DeptVo deptVo) {
        try {
            this.deptService.deleteDept(deptVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 修改学生信息
     */
    @RequestMapping("updateDept")
    public ResultObj updateDept(DeptVo deptVo) {
        try {
            this.deptService.updateDept(deptVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 添加学生
     */
    @RequestMapping("addDept")
    public ResultObj addDept(DeptVo deptVo) {
        try {
            Dept dept = this.deptService.queryLastRow();
            int i = Integer.parseInt(dept.getDeptId());
            deptVo.setDeptId(i+1+"");
            this.deptService.addDept(deptVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

}

