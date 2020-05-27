package top.lemenk.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.lemenk.sys.constant.SysConstant;
import top.lemenk.sys.entity.Teacher;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.entity.UserRole;
import top.lemenk.sys.mapper.RoleMapper;
import top.lemenk.sys.mapper.TeacherMapper;
import top.lemenk.sys.mapper.UserMapper;
import top.lemenk.sys.mapper.UserRoleMapper;
import top.lemenk.sys.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.TeacherVo;
import top.lemenk.sys.vo.UserVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-30
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public DataGridView queryAllTeacher(TeacherVo teacherVo) {
        Page<Object> page = PageHelper.startPage(teacherVo.getPage(), teacherVo.getLimit());
        List<Teacher> data = this.teacherMapper.queryAllTeacher(teacherVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        UserVo userVo = new UserVo();
        UserRole userRole = new UserRole();
        //添加到student表
        this.teacherMapper.insertTeacherInfo(teacher);
        //添加到user表
        userVo.setUsername(teacher.getTechId());
        //设置新学生的密码 稍后修改密文
        userVo.setPassword(SysConstant.USER_DEFAULT_PWD);
        this.userMapper.insert(userVo);
        //添加到user_role表
        userRole.setUserId(userVo.getId());
        userRole.setRoleId(SysConstant.USER_TYPE_TEACHER);
        userRoleMapper.insert(userRole);
    }

    @Override
    public void updateTeacher(TeacherVo teacherVo) {
        this.teacherMapper.updateById(teacherVo);
    }

    @Override
    public void deleteTeacher(String techId) {
        //删除用户
        this.teacherMapper.deleteByTechId(techId);
        //删除user_role表中数据
        this.userRoleMapper.deleteRoleUserByUsername(techId);
        //删除user表中数据
        this.userMapper.deleteUserByUsername(techId);
    }

    @Override
    public void resetUserPwd(String techId) {
        User user = new User();
        user.setUsername(techId);
        // 还原为默认密码
        user.setPassword(SysConstant.USER_DEFAULT_PWD);
        //更新用户表
        this.userMapper.updateUserByUsername(user);
    }

    @Override
    public Teacher teacherInfo(String techId) {
        return teacherMapper.teacherInfo(techId);
    }
}
