package top.lemenk.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.lemenk.sys.entity.LogLogin;
import top.lemenk.sys.entity.News;
import top.lemenk.sys.mapper.NewsMapper;
import top.lemenk.sys.service.INewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lemenk.sys.utils.DataGridView;
import top.lemenk.sys.vo.NewsVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lemenk
 * @since 2020-05-03
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public DataGridView queryAllNews(NewsVo newsVo) {
        Page<Object> page = PageHelper.startPage(newsVo.getPage(), newsVo.getLimit());
        List<News> data = this.newsMapper.queryAllNews(newsVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void addNews(NewsVo newsVo) {
        this.newsMapper.insert(newsVo);
    }

    @Override
    public void updateNews(NewsVo newsVo) {
        this.newsMapper.updateById(newsVo);
    }

    @Override
    public void deleteNews(Integer id) {
        this.newsMapper.deleteById(id);
    }

    @Override
    public void deleteBatchNews(Integer[] ids) {
        for (Integer i : ids) {
            this.deleteNews(i);
        }
    }

    @Override
    public News queryNewsById(Integer id) {
        return this.newsMapper.selectById(id);
    }
}
