package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.lemenk.sys.entity.Teacher;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-25
 */
public interface StaffMapper extends BaseMapper<Staff> {

    /**
     * 查询所有工作人员的信息
     * @param staff
     * @return
     */
    List<Staff> queryAllStaff(Staff staff);

    /**
     * 使用工作人员编号删除工作人员表信息
     * @param staId
     * @return
     */
    int deleteByStaId(String staId);

    /**
     * 添加工作人员信息到工作人员表
     * @param staff
     * @return
     */
    int insertStaffInfo(Staff staff);

    /**
     * 使用工作人员编号查询信息
     * @param staId
     * @return
     */
    Staff staffInfo(String staId);

}
