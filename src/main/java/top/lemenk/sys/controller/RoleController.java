package top.lemenk.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.sys.service.IRoleService;
import top.lemenk.sys.vo.UserVo;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-22
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Resource
    private IRoleService roleService;

    public String getRoleId(String username){
        Integer roleId = roleService.getRoleId(username);
        if (roleId == 0){
            System.out.println("此用户是超级管理员！");
        }else if (roleId == 1){
            System.out.println("此用户是学生！");
        }else if (roleId == 2){
            System.out.println("此用户是教师！");
        }else {
            System.out.println("此用户是工作人员！");
        }
        return "";
    }
}

