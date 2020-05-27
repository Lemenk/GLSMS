package top.lemenk.sys.mapper;

import org.apache.ibatis.annotations.Param;
import top.lemenk.sys.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-26
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询所有菜单
     * @param menu
     * @return
     */
    List<Menu> queryAllMenu(Menu menu);

    /**
     * 通过父菜单id查询该菜单拥有的角色
     * @param pid
     * @return
     */
    List<Integer> queryAllRId(Integer pid);


    /**
     * 查询登录用户的用户名查询该用户拥有的菜单
     * @param username
     * @return
     */
    List<Menu> queryMenuByUsername(String username);

    /**
     * 添加菜单权限到role_menu表
     * @param rid
     * @param mid
     * @return
     */
    int addRoleMenuByMid(@Param("rid")Integer rid, @Param("mid")Integer mid);



    /**
     * 根据父节点id查询子节点数量
     * @param parentId
     * @return
     */
    Integer queryMenuByParentId(@Param("parentId") Integer parentId);


    /**
     * 根据菜单id删除sys_role_menu里面的数据
     * @param id
     */
    void deleteRoleMenuByMid(Integer id);
}
