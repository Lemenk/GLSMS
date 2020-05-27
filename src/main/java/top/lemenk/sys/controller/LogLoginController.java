package top.lemenk.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.sys.service.ILogLoginService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.utils.ResultObj;
import top.lemenk.sys.vo.LogLoginVo;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-02
 */
@RestController
@RequestMapping("log")
public class LogLoginController {

    @Resource
    private ILogLoginService logLoginService;

    /**
     * 加载日志列表返回DataGridView
     */
    @RequestMapping("loadAllLogLogin")
    public DataGridView loadAllLogLogin(LogLoginVo logLoginVo) {
        return this.logLoginService.queryAllLogLogin(logLoginVo);
    }

    /**
     * 删除日志
     */
    @RequestMapping("deleteLogLogin")
    public ResultObj deleteLogLogin(LogLoginVo logLoginVo) {
        try {
            logLoginVo.getId();
            this.logLoginService.deleteLogLogin(logLoginVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除日志
     */
    @RequestMapping("deleteBatchLogLogin")
    public ResultObj deleteBatchLogLogin(LogLoginVo logLoginVo) {
        try {
            this.logLoginService.deleteBatchLogLogin(logLoginVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


}

