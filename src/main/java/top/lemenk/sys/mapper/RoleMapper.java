package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lemenk.sys.vo.UserVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-22
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户登录用户名查询该用户的角色ID
     * @param username
     * @return
     */
    Integer getRoleId(String username);

}
