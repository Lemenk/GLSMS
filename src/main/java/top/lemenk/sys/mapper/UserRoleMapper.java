package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-29
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户名删除用户角色
     * @param username
     */
    void deleteRoleUserByUsername(String username);

}
