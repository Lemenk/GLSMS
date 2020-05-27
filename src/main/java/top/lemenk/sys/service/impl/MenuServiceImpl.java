package top.lemenk.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.lemenk.sys.entity.Menu;
import top.lemenk.sys.mapper.MenuMapper;
import top.lemenk.sys.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.MenuVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryAllMenuForList(MenuVo menuVo) {
        return menuMapper.queryAllMenu(menuVo);
    }

    @Override
    public List<Menu> queryMenuByUsernameForList(String username) {
        System.out.println("mapper : "+username);
        return menuMapper.queryMenuByUsername(username);
    }

    @Override
    public DataGridView queryAllMenu(MenuVo menuVo) {
        Page<Object> page= PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
        List<Menu> data = this.menuMapper.queryAllMenu(menuVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addMenu(MenuVo menuVo) {
        this.menuMapper.insert(menuVo);
        Integer pid = menuVo.getParentId();
        Integer mid = menuVo.getId();
        //rid应该是该菜单的父级菜单的拥有者的角色id
        List<Integer> roles = menuMapper.queryAllRId(pid);
        for (Integer rid: roles) {
            this.menuMapper.addRoleMenuByMid(rid,mid);
        }
    }


    @Override
    public void updateMenu(MenuVo menuVo) {
        this.menuMapper.updateById(menuVo);
    }

    @Override
    public Integer queryMenuByParentId(Integer parentId) {
        return this.menuMapper.queryMenuByParentId(parentId);
    }


    @Override
    public void deleteMenu(MenuVo menuVo) {

        //删除菜单表的数据
        this.menuMapper.deleteById(menuVo.getId());

        //根据菜单id删除sys_role_menu里面的数据
        this.menuMapper.deleteRoleMenuByMid(menuVo.getId());
    }
}
