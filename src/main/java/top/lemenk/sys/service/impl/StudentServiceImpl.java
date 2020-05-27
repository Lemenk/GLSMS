package top.lemenk.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import top.lemenk.sys.constant.SysConstant;
import top.lemenk.sys.entity.Dept;
import top.lemenk.sys.entity.Student;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.entity.UserRole;
import top.lemenk.sys.mapper.*;
import top.lemenk.sys.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.RoleVo;
import top.lemenk.sys.vo.StudentVo;
import top.lemenk.sys.vo.UserVo;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserRoleMapper userRoleMapper;


    @Override
    public DataGridView queryAllStudent(StudentVo studentVo) {
        Page<Object> page = PageHelper.startPage(studentVo.getPage(), studentVo.getLimit());

        List<StudentVo> data = this.studentMapper.queryAllStudent(studentVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addStudent(StudentVo studentVo) {
        UserVo userVo = new UserVo();
        UserRole userRole = new UserRole();
        //添加到student表
        this.studentMapper.insertStudentInfo(studentVo);
        //添加到user表
        userVo.setUsername(studentVo.getStuNo());
        //设置新学生的密码 稍后修改密文
        userVo.setPassword(SysConstant.USER_DEFAULT_PWD);
        this.userMapper.insert(userVo);
        //添加到user_role表
        userRole.setUserId(userVo.getId());
        userRole.setRoleId(SysConstant.USER_TYPE_STUDENT);
        userRoleMapper.insert(userRole);
    }

    @Override
    public void updateStudent(StudentVo studentVo) {
        this.studentMapper.updateById(studentVo);
    }

    @Override
    public void deleteStudent(String stuNo) {
        //删除用户
        this.studentMapper.deleteByStuNo(stuNo);
        //删除user_role表中数据
        this.userRoleMapper.deleteRoleUserByUsername(stuNo);
        //删除user表中数据
        this.userMapper.deleteUserByUsername(stuNo);
    }

    @Override
    public void resetUserPwd(String stuNo) {
        User user = new User();
        user.setUsername(stuNo);
        // 还原为默认密码
        user.setPassword(SysConstant.USER_DEFAULT_PWD);
        //更新用户表
        this.userMapper.updateUserByUsername(user);

    }

    @Override
    public Student studentInfo(String stuNo) {
        return studentMapper.studentInfo(stuNo);
    }
}
