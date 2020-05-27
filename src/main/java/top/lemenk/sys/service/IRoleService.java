package top.lemenk.sys.service;

import top.lemenk.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.sys.vo.RoleVo;
import top.lemenk.sys.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-22
 */
public interface IRoleService extends IService<Role> {

    /**
     * 根据用户登录用户名查询该用户的角色ID
     * @param username
     * @return
     */
    Integer getRoleId(String username);

}
