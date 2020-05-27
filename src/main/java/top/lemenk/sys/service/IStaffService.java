package top.lemenk.sys.service;

import top.lemenk.sys.entity.Staff;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.StaffVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
public interface IStaffService extends IService<Staff> {

    /**
     * 查询所有工作人员
     * @param staffVo
     * @return
     */
    DataGridView queryAllStaff(StaffVo staffVo);

    /**
     * 添加工作人员
     * @param staff
     */
    public void addStaff(Staff staff);

    /**
     * 修改工作人员
     * @param staffVo
     */
    public void updateStaff(StaffVo staffVo);

    /**
     * 根据工作人员编号staId删除工作人员
     * @param staId
     */
    public void deleteStaff(String staId);


    /**
     * 重置密码
     * @param staId
     */
    public void resetUserPwd(String staId);

    /**
     * 使用工作人员编号查询信息
     * @param staId
     * @return
     */
    Staff staffInfo(String staId);

}
