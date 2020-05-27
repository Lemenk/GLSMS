package top.lemenk.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.lemenk.sys.entity.Role;
import top.lemenk.sys.mapper.RoleMapper;
import top.lemenk.sys.service.IRoleService;
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
 * @since 2020-04-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Integer getRoleId(String username) {
        return roleMapper.getRoleId(username);
    }
}
