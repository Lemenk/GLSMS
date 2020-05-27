package top.lemenk.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/4/21 20:28
 * @Description : 工作台控制器
 */

@Controller
@RequestMapping("desk")
public class DeskController {

    /**
     * 跳转到工作台页面
     */

    @RequestMapping("toDeskManager")
    public String toDesk(){
        return "system/main/deskManager";
    }
}
