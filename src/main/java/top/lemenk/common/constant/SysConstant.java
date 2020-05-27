package top.lemenk.common.constant;

public interface SysConstant {


    /**
     * 申请状态
     */
    Integer APPLIED_NOT = 0;
    Integer APPLIED_WAITING = 1;
    Integer APPLIED_TRUE = 2;
    Integer APPLIED_FALSE = 3;

    /**
     * 申请状态
     */
    String APPLIED_INFO_NOT = "未申请";
    String APPLIED_INFO_WAITING = "等待审核";
    String APPLIED_INFO_TRUE = "申请通过";
    String APPLIED_INFO_FALSE = "未通过";

    /**
     * 处理状态码
     */
    Integer HANDLE_NO = 0;
    Integer HANDLE_TRUE = 1;
    Integer HANDLE_FALSE = 2;


    /**
     * 处理状态名称
     */
    String HANDLE_INFO_NO = "未处理";
    String HANDLE_INFO_TRUE = "成功";
    String HANDLE_INFO_FALSE = "失败";
}
