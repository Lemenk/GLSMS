package top.lemenk.common.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.common.constant.SysConstant;
import top.lemenk.common.entity.ApplyHandle;
import top.lemenk.common.service.IApplyHandleService;
import top.lemenk.common.service.IStudentProcessService;
import top.lemenk.common.vo.ApplyHandleVo;
import top.lemenk.common.vo.StudentProcessVo;
import top.lemenk.sys.entity.Staff;
import top.lemenk.sys.entity.Teacher;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.service.IRoleService;
import top.lemenk.sys.service.IStaffService;
import top.lemenk.sys.service.ITeacherService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.utils.ResultObj;
import top.lemenk.sys.utils.WebUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-11
 */
@RestController
@RequestMapping("apply_handle")
public class ApplyHandleController {

    @Resource
    private IApplyHandleService applyHandleService;

    @Resource
    private IStudentProcessService studentProcessService;

    @Resource
    private IRoleService roleService;

    @Resource
    private ITeacherService teacherService;

    @Resource
    private IStaffService staffService;


    /**
     * 加载流程列表返回DataGridView
     */
    @RequestMapping("loadStudentApplyInfo")
    public DataGridView loadStudentApplyInfo(ApplyHandleVo applyHandleVo) {
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        Integer roleId = roleService.getRoleId(user.getUsername());
        if (roleId == 2) {
            applyHandleVo.setTechNo(user.getUsername());
            return this.applyHandleService.queryApplyInfoByTechNo(applyHandleVo);
        }
        applyHandleVo.setStaffNo(user.getUsername());
        return this.applyHandleService.queryApplyInfoByStaNo(applyHandleVo);
    }

    /**
     * 同意申请
     */
    @RequestMapping("agreeApply")
    public ResultObj agreeApply(ApplyHandleVo applyHandleVo) {
        try {
            User user=(User) WebUtils.getHttpSession().getAttribute("user");
            Integer roleId = roleService.getRoleId(user.getUsername());

            System.out.println("从前台传来的id："+applyHandleVo.getId());

            //修改申请处理表
            applyHandleVo.setStatus(SysConstant.HANDLE_TRUE);
            this.applyHandleService.updateApplyHandle(applyHandleVo);

            //修改修改学生流程表
            StudentProcessVo studentProcessVo = new StudentProcessVo();
            //通过id查询学生的申请信息
            ApplyHandle applyHandle = this.applyHandleService.queryApplyHandleById(applyHandleVo.getId());
            System.out.println(applyHandle.getCspId());
            //设置修改的参数
            studentProcessVo.setId(applyHandle.getCspId());
            studentProcessVo.setStuId(applyHandle.getStuId());

            if (roleId == 2) {
                Teacher teacher = teacherService.teacherInfo(user.getUsername());
                studentProcessVo.setHandler(teacher.getTechName());
            }else {
                Staff staff = staffService.staffInfo(user.getUsername());
                studentProcessVo.setHandler(staff.getStaName());
            }

            studentProcessVo.setStatus(SysConstant.APPLIED_TRUE);
            studentProcessVo.setHandleTime(new Date());
            this.studentProcessService.updateStudentProcess(studentProcessVo);

            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 拒绝申请
     */
    @RequestMapping("refuseApply")
    public ResultObj refuseApply(ApplyHandleVo applyHandleVo) {
        try {
            User user=(User) WebUtils.getHttpSession().getAttribute("user");
            Integer roleId = roleService.getRoleId(user.getUsername());

            System.out.println("从前台传来的id："+applyHandleVo.getId());

            //修改申请处理表
            applyHandleVo.setStatus(SysConstant.HANDLE_FALSE);
            this.applyHandleService.updateApplyHandle(applyHandleVo);

            //修改修改学生流程表
            StudentProcessVo studentProcessVo = new StudentProcessVo();
            //通过id查询学生的申请信息
            ApplyHandle applyHandle = this.applyHandleService.queryApplyHandleById(applyHandleVo.getId());
            System.out.println(applyHandle.getCspId());
            //设置修改的参数
            studentProcessVo.setId(applyHandle.getCspId());
            studentProcessVo.setStuId(applyHandle.getStuId());

            if (roleId == 2) {
                Teacher teacher = teacherService.teacherInfo(user.getUsername());
                studentProcessVo.setHandler(teacher.getTechName());
            }else {
                Staff staff = staffService.staffInfo(user.getUsername());
                studentProcessVo.setHandler(staff.getStaName());
            }

            studentProcessVo.setStatus(SysConstant.APPLIED_FALSE);
            studentProcessVo.setHandleTime(new Date());
            this.studentProcessService.updateStudentProcess(studentProcessVo);

            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

}

