package top.lemenk.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;

import top.lemenk.sys.entity.Menu;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-26
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 查询所有菜单返回
     * @param menuVo
     * @return
     */
    List<Menu> queryAllMenuForList(MenuVo menuVo);

    /**
     * 根据用户名查询用户的可用菜单
     * @param username
     * @param username
     * @return
     */
    List<Menu> queryMenuByUsernameForList(String username);

    /**
     * 查询所有菜单
     * @param menuVo
     * @return
     */
    DataGridView queryAllMenu(MenuVo menuVo);

    /**
     * 添加菜单
     * @param menuVo
     */
    void addMenu(MenuVo menuVo);


    /**
     * 修改菜单
     * @param menuVo
     */
    void updateMenu(MenuVo menuVo);

    /**
     * 根据parentId查询菜单数量
     * @param parentId
     * @return
     */
    Integer queryMenuByParentId(Integer parentId);

    /**
     * 根据id删除菜单
     * @param menuVo
     */
    void deleteMenu(MenuVo menuVo);
}
