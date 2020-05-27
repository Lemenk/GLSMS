package top.lemenk.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.lemenk.sys.constant.SysConstant;
import top.lemenk.sys.entity.Staff;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.entity.UserRole;
import top.lemenk.sys.mapper.*;
import top.lemenk.sys.service.IStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.StaffVo;
import top.lemenk.sys.vo.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

    @Resource
    private StaffMapper staffMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserRoleMapper userRoleMapper;


    @Override
    public DataGridView queryAllStaff(StaffVo staffVo) {
        Page<Object> page = PageHelper.startPage(staffVo.getPage(), staffVo.getLimit());
        List<Staff> data = this.staffMapper.queryAllStaff(staffVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addStaff(Staff staff) {
        UserVo userVo = new UserVo();
        UserRole userRole = new UserRole();
        //添加到student表
        this.staffMapper.insertStaffInfo(staff);
        //添加到user表
        userVo.setUsername(staff.getStaId());
        //设置新学生的密码 稍后修改密文
        userVo.setPassword(SysConstant.USER_DEFAULT_PWD);
        this.userMapper.insert(userVo);
        //添加到user_role表
        userRole.setUserId(userVo.getId());
        userRole.setRoleId(SysConstant.USER_TYPE_STAFF);
        userRoleMapper.insert(userRole);
    }

    @Override
    public void updateStaff(StaffVo staffVo) {
        this.staffMapper.updateById(staffVo);
    }

    @Override
    public void deleteStaff(String staId) {
        //删除用户
        this.staffMapper.deleteByStaId(staId);
        //删除user_role表中数据
        this.userRoleMapper.deleteRoleUserByUsername(staId);
        //删除user表中数据
        this.userMapper.deleteUserByUsername(staId);
    }

    @Override
    public void resetUserPwd(String staId) {
        User user = new User();
        user.setUsername(staId);
        // 还原为默认密码
        user.setPassword(SysConstant.USER_DEFAULT_PWD);
        //更新用户表
        this.userMapper.updateUserByUsername(user);
    }

    @Override
    public Staff staffInfo(String staId) {
        return staffMapper.staffInfo(staId);
    }
}
