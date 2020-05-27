package top.lemenk.common.service.impl;

import top.lemenk.common.constant.SysConstant;
import top.lemenk.common.entity.StudentProcess;
import top.lemenk.common.mapper.ApplyHandleMapper;
import top.lemenk.common.mapper.StudentProcessMapper;
import top.lemenk.common.service.IStudentProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.common.vo.StudentProcessVo;
import top.lemenk.sys.mapper.StudentMapper;
import top.lemenk.sys.utils.DataGridView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-07
 */
@Service
public class StudentProcessServiceImpl extends ServiceImpl<StudentProcessMapper, StudentProcess> implements IStudentProcessService {

    @Resource
    private StudentProcessMapper studentProcessMapper;

    @Resource
    private ApplyHandleMapper applyHandleMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void checkYesOrNoFirstLogin(Integer stuId) {
        String s = this.studentProcessMapper.selectYesOrNoFirstLogin(stuId);
        if ("Y".equals(s)){
            //查询
            queryStudentProcessByStuId(stuId);
        }else {
            //插入
            for (int i = 1; i <= 5; i++) {
                StudentProcessVo studentProcessVo = new StudentProcessVo();
                studentProcessVo.setProcId(i);
                studentProcessVo.setStuId(stuId);
                studentProcessVo.setStatus(SysConstant.APPLIED_NOT);
                insertStudentProcess(studentProcessVo);
            }

        }
    }

    @Override
    public int insertStudentProcess(StudentProcessVo studentProcessVo) {
        return studentProcessMapper.insert(studentProcessVo);
    }

    @Override
    public DataGridView queryStudentProcessByStuId(Integer stuId) {
        List<StudentProcess> data = this.studentProcessMapper.queryStudentProcessByStuId(stuId);
        for (StudentProcess sp : data) {
            switch (sp.getStatus()) {
                case 0:
                    sp.setStatusName(SysConstant.APPLIED_INFO_NOT);
                    break;
                case 1:
                    sp.setStatusName(SysConstant.APPLIED_INFO_WAITING);
                    break;
                case 2:
                    sp.setStatusName(SysConstant.APPLIED_INFO_TRUE);
                    break;
                default:
                    sp.setStatusName(SysConstant.APPLIED_INFO_FALSE);
            }
        }
        return new DataGridView(data);
    }

    @Override
    public int updateStudentProcess(StudentProcessVo studentProcessVo) {
        return this.studentProcessMapper.updateById(studentProcessVo);
    }

    @Override
    public StudentProcess queryStudentProcessById(Integer id) {
        return this.studentProcessMapper.selectById(id);
    }
}
