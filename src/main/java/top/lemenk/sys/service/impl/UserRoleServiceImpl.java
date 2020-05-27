package top.lemenk.sys.service.impl;

import top.lemenk.sys.entity.UserRole;
import top.lemenk.sys.mapper.UserRoleMapper;
import top.lemenk.sys.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-29
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
