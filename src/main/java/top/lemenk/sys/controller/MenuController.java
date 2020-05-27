package top.lemenk.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.sys.constant.SysConstant;
import top.lemenk.sys.entity.Menu;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.service.IMenuService;
import top.lemenk.sys.service.IRoleService;
import top.lemenk.sys.utils.*;
import top.lemenk.sys.vo.MenuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-26
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("loadIndexLeftMenuJson")
    public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo){
        //得到当前登陆的用户对象
        User user=(User) WebUtils.getHttpSession().getAttribute("user");
        //查询用户的菜单
        List<Menu> list=this.menuService.queryMenuByUsernameForList(user.getUsername());

        List<TreeNode> nodes= new ArrayList<>();
        //把list里面的数据放到nodes
        for (Menu menu : list) {
            Integer id = menu.getId();
            Integer parentId = menu.getParentId();
            String title = menu.getTitle();
            String href = menu.getHref();
            String icon = menu.getIcon();
            Boolean spread = menu.getSpread().equals(SysConstant.SPREAD_TRUE) ? true:false;
            nodes.add(new TreeNode(id, parentId, title, href, icon, spread));
        }
        return TreeNodeBuilder.builder(nodes, 1);
    }

    @RequestMapping("loadMenuManagerLeftTreeJson")
    public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo){
        List<Menu> list=this.menuService.queryAllMenuForList(menuVo);
        List<TreeNode> nodes= new ArrayList<>();
        //把list里面的数据放到nodes
        for (Menu menu : list) {
            Integer id = menu.getId();
            Integer parentId = menu.getParentId();
            String title = menu.getTitle();
            String href = menu.getHref();
            String icon = menu.getIcon();
            Boolean spread = menu.getSpread().equals(SysConstant.SPREAD_TRUE) ? true:false;
            nodes.add(new TreeNode(id, parentId, title, href, icon, spread));
        }
        return new DataGridView(nodes);
    }

    /**
     * 加载菜单列表返回DataGridView
     */
    @RequestMapping("loadAllMenu")
    public DataGridView loadAllMenu(MenuVo menuVo) {
        return this.menuService.queryAllMenu(menuVo);
    }

    /**
     * 添加菜单
     */
    @RequestMapping("addMenu")
    public ResultObj addMenu(MenuVo menuVo) {
        try {
            this.menuService.addMenu(menuVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改菜单
     */
    @RequestMapping("updateMenu")
    public ResultObj updateMenu(MenuVo menuVo) {
        try {
            this.menuService.updateMenu(menuVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 根据id判断当前菜单有没有子节点
     *    有返回code>=0
     *   没有返回code<0
     * @param menuVo
     * @return
     */
    @RequestMapping("checkMenuHasChildren")
    public ResultObj checkMenuHasChildren(MenuVo menuVo){
        //根据parentId查询菜单数量
        Integer count=this.menuService.queryMenuByParentId(menuVo.getId());
        if(count>0) {
            return ResultObj.STATUS_TRUE;
        }else {
            return ResultObj.STATUS_FALSE;
        }
    }

    /**
     * 删除菜单
     */
    @RequestMapping("deleteMenu")
    public ResultObj deleteMenu(MenuVo menuVo) {
        try {
            this.menuService.deleteMenu(menuVo);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

