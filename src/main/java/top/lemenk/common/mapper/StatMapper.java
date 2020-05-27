package top.lemenk.common.mapper;

import top.lemenk.common.entity.BaseEntity;

import java.util.List;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/13 12:35
 * @Description :
 */
public interface StatMapper {

    /**
     * 查询所有申请
     * @return
     */
    List<BaseEntity> queryApply();

    /**
     * 查询所有处理
     * @return
     */
    List<BaseEntity> queryHandle();
}
