package top.lemenk.sys.service;

import top.lemenk.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.sys.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-18
 */
public interface IUserService {

    /**
     * 用户登录
     * @param userVo
     * @return
     */
    User login(UserVo userVo);

    /**
     * 修改密码
     * @return
     */
    int updatePwd(UserVo userVo);
}
