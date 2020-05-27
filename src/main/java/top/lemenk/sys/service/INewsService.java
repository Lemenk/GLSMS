package top.lemenk.sys.service;

import top.lemenk.sys.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.NewsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-03
 */
public interface INewsService extends IService<News> {

    /**
     * 查询所有新闻
     * @param newsVo
     * @return
     */
    DataGridView queryAllNews(NewsVo newsVo);

    /**
     * 添加新闻
     * @param newsVo
     */
    void addNews(NewsVo newsVo);

    /**
     * 更新新闻
     * @param newsVo
     */
    void updateNews(NewsVo newsVo);

    /**
     * 根据id删除新闻
     * @param id
     */
    void deleteNews(Integer id);

    /**
     * 批量删除新闻
     * @param ids
     */
    void deleteBatchNews(Integer[] ids);

    /**
     * 根据id查询新闻
     * @param id
     * @return
     */
    News queryNewsById(Integer id);

}
