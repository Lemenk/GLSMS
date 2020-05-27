package top.lemenk.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/4/26 11:15
 * @Description : 页面跳转控制器
 */

@Controller
@RequestMapping("sys")
public class SysController {

    /**
     * 跳转到菜单管理
     * @return
     */
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "/system/menu/menuManager";
    }

    /**
     * 跳转菜单管理左边的的菜单树页面
     */
    @RequestMapping("toMenuLeft")
    public String toMenuLeft() {
        return "system/menu/menuLeft";
    }

    /**
     * 跳转菜单管理右边的菜单列表
     */
    @RequestMapping("toMenuRight")
    public String toMenuRight() {
        return "system/menu/menuRight";
    }

    /**
     * 跳转到学生管理页面
     * @return
     */
    @RequestMapping("toStudentManager")
    public String toStudentManager(){
        return "system/user/studentManager";
    }
    /**
     * 跳转到教师管理页面
     * @return
     */
    @RequestMapping("toTeacherManager")
    public String toTeacherManager(){
        return "system/user/teacherManager";
    }
    /**
     * 跳转到工作人员管理页面
     * @return
     */
    @RequestMapping("toStaffManager")
    public String toStaffManager(){
        return "system/user/staffManager";
    }

    /**
     * 跳转到部门管理页面
     * @return
     */
    @RequestMapping("toDeptManager")
    public String toDeptManager(){
        return "system/dept/deptManager";
    }

    /**
     * 跳转到日志管理页面
     * @return
     */
    @RequestMapping("toLoginLogManager")
    public String toLoginLogManager(){
        return "system/log/loginLogManager";
    }

    /**
     * 跳转到公告管理页面
     * @return
     */
    @RequestMapping("toNewsManager")
    public String toNewsManager(){
        return "system/news/newsManager";
    }

    /**
     * 跳转到学生离校申请页面
     * @return
     */
    @RequestMapping("toProcessManager")
    public String toProcessManager(){
        return "common/student/studentOpert";
    }

    /**
     * 跳转到教师处理离校申请页面
     * @return
     */
    @RequestMapping("toTeacherHandleManager")
    public String toTeacherHandleManager(){
        return "common/teacher/teacherOpert";
    }

    /**
     * 跳转到工作人员处理离校申请页面
     * @return
     */
    @RequestMapping("toStaffHandleManager")
    public String toStaffHandleManager(){
        return "common/staff/staffOpert";
    }

    /**
     * 跳转到学生个人信息页面
     * @return
     */
    @RequestMapping("toStudentInfo")
    public String toStudentInfo(){
        return "system/userInfo/studentInfo";
    }

    /**
     * 跳转到教师个人信息页面
     * @return
     */
    @RequestMapping("toTeacherInfo")
    public String toTeacherInfo(){
        return "system/userInfo/teacherInfo";
    }

    /**
     * 跳转到工作人员个人信息页面
     * @return
     */
    @RequestMapping("toStaffInfo")
    public String toStaffInfo(){
        return "system/userInfo/staffInfo";
    }
}
