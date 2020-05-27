package top.lemenk.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lemenk.common.entity.BaseEntity;
import top.lemenk.common.service.IStatService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/13 10:24
 * @Description :
 */
@RequestMapping("stat")
@Controller
public class StatController {

    @Resource
    private IStatService statService;

    @RequestMapping("toStudentApplyStat")
    public String toStudentApplyStat(){
        return "system/stat/applyManager";
    }

    @RequestMapping("toHandleStat")
    public String toHandleStat(){
        return "system/stat/handleManager";
    }

    @RequestMapping("loadApplyStatJson")
    @ResponseBody
    public List<BaseEntity> loadApplyStatJson(){
        return this.statService.loadApplyStat();
    }

    @RequestMapping("loadHandleStatJson")
    @ResponseBody
    public List<BaseEntity> loadHandleStatJson(){
        return this.statService.loadHandleStat();
    }
}
