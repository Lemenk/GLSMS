package top.lemenk.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.lemenk.sys.entity.Dept;
import top.lemenk.sys.mapper.DeptMapper;
import top.lemenk.sys.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.DeptVo;
import top.lemenk.sys.vo.StudentVo;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-04-28
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Resource
    private DeptMapper deptMapper;


    @Override
    public DataGridView queryAllDept(DeptVo deptVo) {
        Page<Object> page = PageHelper.startPage(deptVo.getPage(), deptVo.getLimit());

        List<DeptVo> data = this.deptMapper.queryAllDept(deptVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public List<Dept> queryStaDept(Dept dept) {
        return deptMapper.queryStaDept(dept);
    }

    @Override
    public List<Dept> queryColDept(Dept dept) {
        return deptMapper.queryColDept(dept);
    }

    @Override
    public Dept queryDeptByDeptId(String deptId) {
        return deptMapper.queryDeptByDeptId(deptId);
    }

    @Override
    public int deleteDept(Integer id) {
        return deptMapper.deleteById(id);
    }

    @Override
    public int updateDept(DeptVo deptVo) {
        return this.deptMapper.updateById(deptVo);
    }

    @Override
    public int addDept(DeptVo deptVo) {
        return this.deptMapper.insert(deptVo);
    }

    @Override
    public Dept queryLastRow() {
        return this.deptMapper.queryLastRow();
    }
}
