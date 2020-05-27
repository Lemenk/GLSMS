package top.lemenk.common.service;

import top.lemenk.common.entity.BaseEntity;

import java.util.List;

/**
 * @author : Lemenk
 * @Blog : blog.lemenk.top
 * @date : 2020/5/13 12:22
 * @Description :
 */
public interface IStatService {


    /**
     * 学生申请信息统计
     * @return
     */
    List<BaseEntity> loadApplyStat();

    /**
     * 处理情况统计
     * @return
     */
    List<BaseEntity> loadHandleStat();
}
