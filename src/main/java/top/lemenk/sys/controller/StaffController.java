package top.lemenk.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.sys.entity.Staff;
import top.lemenk.sys.service.IStaffService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.utils.ResultObj;
import top.lemenk.sys.vo.StaffVo;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
@RestController
@RequestMapping("staff")
public class StaffController {

    @Resource
    private IStaffService staffService;

    /**
     * 加载工作人员列表返回DataGridView
     */
    @RequestMapping("loadAllStaff")
    public DataGridView loadAllStaff(StaffVo staffVo) {
        return this.staffService.queryAllStaff(staffVo);
    }

    /**
     * 添加工作人员
     */
    @RequestMapping("addStaff")
    public ResultObj addStaff(Staff staff) {
        try {
            this.staffService.addStaff(staff);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改工作人员信息
     */
    @RequestMapping("updateStaff")
    public ResultObj updateStaff(StaffVo staffVo) {
        try {
            this.staffService.updateStaff(staffVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    /**
     * 删除工作人员
     */
    @RequestMapping("deleteStaff")
    public ResultObj deleteStaff(StaffVo staffVo) {
        try {
            this.staffService.deleteStaff(staffVo.getStaId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 重置工作人员登录密码
     */
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(StaffVo staffVo) {
        try {
            this.staffService.resetUserPwd(staffVo.getStaId());
            return ResultObj.RESET_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.RESET_ERROR;
        }
    }
}

