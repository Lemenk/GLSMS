package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-18
 */
public interface UserMapper  extends BaseMapper<User> {

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 根据用户名删除用户
     * @param username
     */
    void deleteUserByUsername(String username);

    /**
     * 更新用户表信息
     * @param user
     * @return
     */
    int updateUserByUsername(User user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    int updatePwd(User user);
}
