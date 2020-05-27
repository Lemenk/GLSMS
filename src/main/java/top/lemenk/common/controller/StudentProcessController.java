package top.lemenk.common.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.common.constant.SysConstant;
import top.lemenk.common.entity.StudentProcess;
import top.lemenk.common.service.IApplyHandleService;
import top.lemenk.common.service.IProcessService;
import top.lemenk.common.service.IStudentProcessService;
import top.lemenk.common.vo.ApplyHandleVo;
import top.lemenk.common.vo.StudentProcessVo;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.service.IStudentService;
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
 * @since 2020-05-07
 */
@RestController
@RequestMapping("student_process")
public class StudentProcessController {
    @Resource
    private IStudentProcessService studentProcessService;

    @Resource
    private IProcessService processService;

    @Resource
    private IApplyHandleService applyHandleService;

    @Resource
    private IStudentService studentService;

    /**
     * 加载流程列表返回DataGridView
     */
    @RequestMapping("loadStudentProcess")
    public DataGridView loadStudentProcess() {
        //得到当前登录的用户
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        return this.studentProcessService.queryStudentProcessByStuId(user.getId());
    }

    /**
     * 执行申请功能
     */
    @RequestMapping("studentApply")
    public ResultObj studentApply(StudentProcessVo studentProcessVo) {
        try {
            System.out.println("从前台传来的id："+studentProcessVo.getId());
            //修改当前状态
            studentProcessVo.setStatus(SysConstant.APPLIED_WAITING);
            studentProcessVo.setApplyTime(new Date());
            this.studentProcessService.updateStudentProcess(studentProcessVo);
            //通过id查询学生的申请信息
            StudentProcess studentProcess = this.studentProcessService.queryStudentProcessById(studentProcessVo.getId());
            System.out.println("得到学生的id："+studentProcess.getStuId());

            //提交申请
            ApplyHandleVo applyHandleVo = new ApplyHandleVo();
            applyHandleVo.setCspId(studentProcessVo.getId());
            this.applyHandleService.insertApplyInfo(applyHandleVo);

            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
}

