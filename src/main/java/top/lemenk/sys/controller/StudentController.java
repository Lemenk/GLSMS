package top.lemenk.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.sys.entity.Student;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.service.IStudentService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.utils.ResultObj;
import top.lemenk.sys.utils.WebUtils;
import top.lemenk.sys.vo.StudentVo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
@RestController
@RequestMapping("student")
public class StudentController {



    @Autowired
    private IStudentService studentService;

    /**
     * 加载学生列表返回DataGridView
     */
    @RequestMapping("loadAllStudent")

    public DataGridView loadAllStudent(StudentVo studentVo) {
        return this.studentService.queryAllStudent(studentVo);
    }


    /**
     * 添加学生
     */
    @RequestMapping("addStudent")
    public ResultObj addStudent(StudentVo studentVo) {
        try {
            this.studentService.addStudent(studentVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改学生信息
     */
    @RequestMapping("updateStudent")
    public ResultObj updateStudent(StudentVo studentVo) {
        try {
            this.studentService.updateStudent(studentVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    /**
     * 删除学生
     */
    @RequestMapping("deleteStudent")
    public ResultObj deleteStudent(StudentVo studentVo) {
        try {
            this.studentService.deleteStudent(studentVo.getStuNo());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 重置学生登录密码
     */
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(StudentVo studentVo) {
        try {
            this.studentService.resetUserPwd(studentVo.getStuNo());
            return ResultObj.RESET_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }



    /**
     * 得到学生的信息
     * @return
     */
    @RequestMapping("studentInfo")
    public Student studentInfo(){
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        return this.studentService.studentInfo(user.getUsername());
    }


}

