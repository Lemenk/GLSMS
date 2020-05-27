package top.lemenk.common.service.impl;

import top.lemenk.common.entity.Process;
import top.lemenk.common.mapper.ProcessMapper;
import top.lemenk.common.service.IProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-07
 */
@Service
public class ProcessServiceImpl extends ServiceImpl<ProcessMapper, Process> implements IProcessService {

}
