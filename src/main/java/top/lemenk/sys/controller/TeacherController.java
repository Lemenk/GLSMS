package top.lemenk.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.sys.entity.Teacher;
import top.lemenk.sys.service.ITeacherService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.utils.ResultObj;
import top.lemenk.sys.vo.TeacherVo;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-30
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;

    /**
     * 加载教师列表返回DataGridView
     */
    @RequestMapping("loadAllTeacher")
    public DataGridView loadAllTeacher(TeacherVo teacherVo) {
        return this.teacherService.queryAllTeacher(teacherVo);
    }

    /**
     * 添加教师
     */
    @RequestMapping("addTeacher")
    public ResultObj addTeacher(Teacher teacher) {
        try {
            this.teacherService.addTeacher(teacher);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改教师信息
     */
    @RequestMapping("updateTeacher")
    public ResultObj updateTeacher(TeacherVo teacherVo) {
        try {
            this.teacherService.updateTeacher(teacherVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    /**
     * 删除教师
     */
    @RequestMapping("deleteTeacher")
    public ResultObj deleteTeacher(TeacherVo teacherVo) {
        try {
            this.teacherService.deleteTeacher(teacherVo.getTechId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 重置教师登录密码
     */
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(TeacherVo teacherVo) {
        try {
            this.teacherService.resetUserPwd(teacherVo.getTechId());
            return ResultObj.RESET_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }

}

