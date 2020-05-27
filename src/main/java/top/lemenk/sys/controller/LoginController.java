package top.lemenk.sys.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import top.lemenk.common.service.IStudentProcessService;
import top.lemenk.sys.constant.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import top.lemenk.sys.entity.Staff;
import top.lemenk.sys.entity.Student;
import top.lemenk.sys.entity.Teacher;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.service.*;
import top.lemenk.sys.utils.WebUtils;
import top.lemenk.sys.vo.LogLoginVo;
import top.lemenk.sys.vo.UserVo;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-18
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private IStaffService staffService;

    @Autowired
    private ILogLoginService logLoginService;

    @Resource
    private IStudentProcessService studentProcessService;


    /**
     * 跳转到登陆页面
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "system/main/login";
    }


    /**
     * 登陆方法
     */
    @RequestMapping("login")
    public String login(UserVo userVo, Model model) {
        String code = WebUtils.getHttpSession().getAttribute("code").toString();
        if (userVo.getCode().equals(code)){
            User user=this.userService.login(userVo);
            if(null!=user) {
                //放到session
                WebUtils.getHttpSession().setAttribute("user", user);
                String username = user.getUsername();

                //记录登陆日志 向sys_login_log里面插入数据
                LogLoginVo logLoginVo = new LogLoginVo();
                logLoginVo.setLoginTime(new Date());
                logLoginVo.setLoginUsername(user.getUsername());

                //获取用户的角色id
                Integer roleId = roleService.getRoleId(username);
                switch (roleId) {
                    case 0:
                        System.out.println("此用户是超级管理员！");
                        model.addAttribute("role", "超级管理员");
                        model.addAttribute("name","超级管理员");
                        logLoginVo.setLoginRole("超级管理员");
                        break;
                    case 1:
                        System.out.println("此用户是学生！");
                        Student student = studentService.studentInfo(username);
                        model.addAttribute("user", student);
                        model.addAttribute("name", student.getStuName());
                        model.addAttribute("role", "学生");
                        logLoginVo.setLoginRole("学生");
                        //学生登陆后查询是不是第一次登录
                        studentProcessService.checkYesOrNoFirstLogin(student.getId());
                        WebUtils.getHttpSession().setAttribute("student", student);
                        break;
                    case 2:
                        System.out.println("此用户是教师！");
                        Teacher teacher = teacherService.teacherInfo(username);
                        model.addAttribute("user", teacher);
                        model.addAttribute("name", teacher.getTechName());
                        model.addAttribute("role", "教师");
                        logLoginVo.setLoginRole("教师");
                        WebUtils.getHttpSession().setAttribute("teacher", teacher);
                        break;
                    default:
                        System.out.println("此用户是工作人员！");
                        Staff staff = staffService.staffInfo(username);
                        model.addAttribute("user", staff);
                        model.addAttribute("name", staff.getStaName());
                        model.addAttribute("role", "工作人员");
                        logLoginVo.setLoginRole("工作人员");
                        WebUtils.getHttpSession().setAttribute("staff", staff);
                }
                logLoginVo.setLoginIp(WebUtils.getHttpServletRequest().getRemoteAddr());
                logLoginService.addLogLogin(logLoginVo);

                return "system/main/index";
            }else {
                model.addAttribute("error", SysConstant.USER_LOGIN_ERROR_MSG);
                return "system/main/login";
            }
        }else {
            model.addAttribute("error", SysConstant.USER_LOGIN_CODE_ERROR_MSG);
            return "system/main/login";
        }

    }

    /**
     * 得到登录验证码
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116,36,4,5);
        session.setAttribute("code",lineCaptcha.getCode());
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(lineCaptcha.getImage(),"JPEG",outputStream);
    }

}

