package top.lemenk.sys.mapper;

import top.lemenk.sys.entity.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-03
 */
public interface NewsMapper extends BaseMapper<News> {

    /**
     * 查询所有的新闻
     * @param news
     * @return
     */
    List<News> queryAllNews(News news);

}
