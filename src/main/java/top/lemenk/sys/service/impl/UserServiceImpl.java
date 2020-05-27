package top.lemenk.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.mapper.UserMapper;
import top.lemenk.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.sys.vo.UserVo;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-18
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(UserVo userVo) {
        User user = userMapper.login(userVo);
        return userMapper.login(userVo);
    }

    @Override
    public int updatePwd(UserVo userVo) {
        return 0;
    }
}
