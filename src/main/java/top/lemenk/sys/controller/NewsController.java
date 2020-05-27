package top.lemenk.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.lemenk.sys.entity.News;
import top.lemenk.sys.entity.User;
import top.lemenk.sys.service.INewsService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.utils.ResultObj;
import top.lemenk.sys.utils.WebUtils;
import top.lemenk.sys.vo.NewsVo;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-03
 */
@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    /**
     * 加载公告列表返回DataGridView
     */
    @RequestMapping("loadAllNews")
    public DataGridView loadAllNews(NewsVo newsVo) {
        return this.newsService.queryAllNews(newsVo);
    }

    /**
     * 添加公告
     */
    @RequestMapping("addNews")
    public ResultObj addNews(NewsVo newsVo) {
        try {
            newsVo.setCreateTime(new Date());
            newsVo.setOperName("系统");
            this.newsService.addNews(newsVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    /**
     * 修改公告
     */
    @RequestMapping("updateNews")
    public ResultObj updateNews(NewsVo newsVo) {
        try {
            this.newsService.updateNews(newsVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 删除公告
     */
    @RequestMapping("deleteNews")
    public ResultObj deleteNews(NewsVo newsVo) {
        try {
            this.newsService.deleteNews(newsVo.getId());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除公告
     */
    @RequestMapping("deleteBatchNews")
    public ResultObj deleteBatchNews(NewsVo newsVo) {
        try {
            this.newsService.deleteBatchNews(newsVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @RequestMapping("loadNewsById")
    public News loadNewsById(Integer id){
        return this.newsService.queryNewsById(id);
    }
}

