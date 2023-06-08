package com.sumvibe.springboot.utils;

public class ConstValues {

    /**
     * 系统语言-中文-zh_CN
     */
    public final static String SYS_LANG_ZH_CN = "zh_CN";

    /**
     * 系统语言-中文-zh_CN名称
     */
    public final static String SYS_LANG_ZH_CN_NAME = "中文";

    /**
     * 树形组织展示状态
     */
    public final static String STATE = "closed";

    /**
     * 组织：所属系统-根节点：ROOT
     */
    public final static String SYS_ID_ROOT = "ROOT";
    /**
     * 批量插入：
     */
    public static int LENGTH = 500;

    /**
     * 每个文件数据条数：
     */
    public final static int FILE_DATA_LENGTH = 500000;

    /**
     * 分布式锁value
     */
    public final static String LOCK_VALUE = "1";

    //机构类型
    public final static String ORG_TYPE_0 = "0";//总行
    public final static String ORG_TYPE_1 = "1";//一级分行
    public final static String ORG_TYPE_2 = "2";//直属分行
    public final static String ORG_TYPE_3 = "3";//二级分行

    //未知类型提示
    public static final String DEFAULT_CODES_MSG = "未知";
    public static final String DEFAULT_CODES_CODE = "408";


    public static final String SESSION_REDIS_FRONT_STAMP = "call_session_";

    public static final int SESSION_VALIDITY = 60 * 60;


    /**
     * 银行参数类型
     */
    public static final class CodeType {
        //获取卡片寄送地址的类型 CODES/ADML
        public static final String CARD_TO_ADDR_TYPE = "ADML";
        //获取账单分期邮递方式 CODES/STMCD
        public static final String BILL_MAIL_TYPE = "STMCD";
        //根据证件名获取证件类型 CODES/ETHNC
        public static final String KEY_TYPE = "ETHNC";
        //关系值 CODES/CNREL
        public static final String ANALYTICAL_RELATIONS = "CNREL";
        //获取分期类型 CODES/MPTYP
        public static final String STAGE_TYPE = "MPTYP";
    }

    /**
     * 退卡重邮 本部 、 外部
     */
    public static final class AddressType {
        public static final String THIS_PART = "1"; //本部
        public static final String THIS_PART_VALUE = "本部"; //本部
        public static final String EXTERNAL = "2"; //外部
        public static final String EXTERNAL_VALUE = "外部"; //外部
    }

    /**
     * 任务状态
     */
    public static final class TaskStatus {

//        public final static String TASK_STATUS_DELETED = "-1";   //已删除
//        public final static String TASK_STATUS_WAITING = "0";    //等待中
//        public final static String TASK_STATUS_RUNNING = "1";    //执行中
//        public final static String TASK_STATUS_PASUED = "2";     //已暂停
//        public final static String TASK_STATUS_OVER = "3";       //已结束


        public static final int TASK_STATUS_HANGUP = 6; //挂起（非工作时间内）
        public static final String TASK_STATUS_HANGUP_NAME = "挂起"; //挂起（非工作时间内）
        public static final int TASK_STATUS_RUNNING = 5; //运行
        public static final String TASK_STATUS_RUNNING_NAME = "运行"; //运行
        public static final int TASK_STATUS_BLOCKING = 4;//阻塞
        public static final String TASK_STATUS_BLOCKING_NAME = "阻塞";//阻塞
        public static final int TASK_STATUS_WAITING = 3;//等待
        public static final String TASK_STATUS_WAITING_NAME = "等待";//等待
        public static final int TASK_STATUS_PAUSING = 2; // 暂停
        public static final String TASK_STATUS_PAUSING_NAME = "暂停"; // 暂停
        public static final int TASK_STATUS_FINISH = 1;  //结束
        public static final String TASK_STATUS_FINISH_NAME = "结束";  //结束
        public static final int TASK_STATUS_DELETED = 0; //删除
        public static final String TASK_STATUS_DELETED_NAME = "删除"; //删除
        public static final int TASK_STATUS_DEFAULT = 9;
        public static final String TASK_STATUS_DEFAULT_NAME = "初始化";

    }

    /**
     * 任务状态标志
     */
    public static final class TaskStatusFlag {

        public static final String TASK_STATUS_ALL_PAUSE = "0"; //一键暂停标志
        public static final String TASK_STATUS_ALL_RECOVERY = "1"; //一键恢复标志

    }

    /**
     * 定时任务名称
     */
    public static final class TimingTaskNames {
        public static final String EFTP_MSG_TASK_NAME = "eftp_msg_task_name"; //接收消息的定时任务名称
        public static final String EFTP_DOWNLOAD_TASK_NAME = "eftp_download_task_name"; //下载文件的定时任务名称
        public static final String EFTP_UPLOAD_TASK_NAME = "eftp_upload_task_name"; //上传拒绝原因的定时任务名称
        public static final String EFTP_UPLOAD_RETURN_CARD_TASK_NAME = "eftp_upload_return_card_task_name"; //上传退卡重邮定时任务名称
        public static final String EFTP_CUSTOM_UPLOAD_TASK_NAME = "eftp_custom_upload_task_name"; //上传账单分期电话客户的定时任务名称
        public static final String EFTP_ACCEPT_UPLOAD_TASK_NAME = "eftp_accept_upload_task_name"; //上传账单分期电话客户的定时任务名称
        public static final String EFTP_RECORD_UPLOAD_TASK_NAME = "eftp_record_upload_task_name"; //上传record的定时任务名称
        public static final String EFTP_REPORT_UPLOAD_TASK_NAME = "eftp_report_upload_task_name"; //上传report的定时任务名称


        public static final String EFTP_PARAM_TASK_NAME = "eftp_param_task_name"; //下载参数文件的定时任务名称
        public static final String EFTP_PARAM_CODES_ANALYSIS_TASK_NAME = "eftp_param_codes_analysis_task_name"; //解析已经下载的CODES参数表
        public static final String EFTP_PARAM_PRPRD_ANALYSIS_TASK_NAME = "eftp_param_prprd_analysis_task_name"; //解析已经下载的PRPRD参数表
        public static final String EFTP_PARAM_PCPDR_ANALYSIS_TASK_NAME = "eftp_param_pcpdr_analysis_task_name"; //解析已经下载的PCPDR参数表
        public static final String EFTP_PARAM_CLOCD_ANALYSIS_TASK_NAME = "eftp_param_clocd_analysis_task_name"; //解析已经下载的CLOCD参数表
        public static final String UPDATE_TASK_CONFIG_NAME = "update_timing_task_config"; //更新定时任务的名称
        public static final String EFTP_AUTO_IMPORT_TASK_NAME = "eftp_auto_import_task_name";//自动导入定时任务名称
        public static final String OCS_DAYEND_UPDATE_CALL_STATUS_TASK_NAME = "ocs_dayend_update_call_status_task_name";//日终结果插入记录表中
        public static final String REPORT_OCS_DAYEND_UPDATE_CALL_STATUS_TASK_NAME = "report_ocs_dayend_update_call_status_task_name";//日终结果插入报表库记录表中
        public static final String BILL_DS_INSERT_TASK_NAME = "bill_ds_insert_task_name";//账单分期定时插入银联数据
        public static final String CASH_DS_INSERT_TASK_NAME = "cash_ds_insert_task_name";//现金分期定时插入银联数据
        public static final String ASSIST_DS_INSERT_TASK_NAME = "assist_ds_insert_task_name";//促激活定时插入银联数据
        public static final String RETURN_DS_INSERT_TASK_NAME = "return_ds_insert_task_name";//退卡重游定时插入银联数据
        public static final String QUALITY_DS_INSERT_TASK_NAME = "quality_ds_insert_task_name";//交叉发卡定时插入银联数据
        public static final String QUALITY_NEW_DS_INSERT_TASK_NAME = "quality_ds_insert_task_name";//交叉发卡新场景定时插入银联数据
        public static final String YX_QUALITY_DS_INSERT_TASK_NAME = "yx_quality_ds_insert_task_name";//悦享发卡定时插入银联数据
        public static final String YX_QUALITY_BY_BILL_INSERT_TASK_NAME = "yx_quality_by_bill_insert_task_name";//悦享发卡搭销定时插入客户信息数据
        public static final String UPDATE_TASKS_STATUS = "update_tasks_status";//定時更新tasks的status
        public static final String UPDATE_BUSINESS_STATUS = "update_business_status";//定時更新业务数据的有效期
        public static final String UPDATE_OMP_USER_INFO = "update_omp_user_info";//定時更新redis中的omp的所有用户信息
        public static final String BILL_SUCCEED_PER_DS_INSERT_TASK_NAME = "bill_succeed_per_ds_insert_task_name";//定時更新或者新增账单分期成功率
        public static final String UPDATE_WORK_ORDER_STATUS = "update_work_order_status";//定時更新工单的预警状态
        public static final String RECYCLE_DAYEND_DATA = "recycle_dayend_data";//自动回收日终表数据
        public static final String DATA_LAST_MONTH_DOWNLOAD = "data_last_month_download_task_name";//自动拉去上个月月底的文件
        public static final String CREATE_RETURN_CARD_IVRTASK = "create_return_card_ivrtask_task_name";//定时创建IVR任务
        public static final String CLEAN_LOCAL_FILES = "clean_local_files";//定时清理存储在本地的上传文件
        public static final String BILL_MONTHLY_INSERT_TASK_NAME = "bill_monthly_insert_task_name";//账单分期月报定时插入数据
        public static final String MARKET_SPECIAL_LIST_INSERT_TASK_NAME="market_special_list_insert_task_name";//营销特殊名单定时插入数据
        public static final String SPECIAL_LIST_SYN_IDENTITY_CARD_ID_TASK_NAME = "special_list_syn_identity_card_id_task_name";//特殊名单同步身份证号
        public static final String PLAN_LIST_INSERT_TASK_NAME="plan_list_insert_task_name";//计划列表定时插入数据
        public static final String ISSU_CARD_SUCC_INFO_TASK_NAME="issu_card_succ_info_task_name";//交叉营销批卡成功定时插入数据
        public static final String YSASSIST_ORG_INFO_INSERT_TASK_NAME="yxassist_org_info_ds_insert_task_name";//悦享分期机构信息表定时插入数据
        public static final String SYS_MAP_INSERT_TASK_NAME="sys_map_insert_task_name";//电子地图定时插入数据
        public static final String CAS_PAD_JGQL_TASK_NAME="cas_pad_jgql_task_name";//激活机构定时插入数据
        public static final String QUALITY_PULL_TASK_NAME = "quality_pull_task_name";//定时拉取服务器上的交叉发卡文件
        public static final String QUALITY_PULL_TASK_NAME_NEW = "quality_pull_task_name_new";//定时拉取服务器上的交叉发卡新场景文件
        public static final String YX_QUALITY_DATA_STATUS_TASK_NAME = "yx_quality_data_status_task_name";//处理悦享发卡拒批数据
    }

    /**
     * 参数文件名称
     */
    public static final class ParamFileName {
        public static final String CODES = "CODES"; //CODES
        public static final String PRPRD = "PRPRD"; //PRPRD
        public static final String PCPDR = "PCPDR"; //PCPDR
        public static final String CLOCD = "CLOCD"; //CLOCD
        public static final String PARAM_FILE_SUFFIX = "txt"; //txt

    }

    /**
     * 数据共享业务文件名称
     */
    public static final class BusinessFileName {
        public static final String YX_ORG_ASSIT = "INN_ORG_REL";//悦享分期机构信息表
        public static final String INVIT_BILPMT_D = "DXWH_CRCARD_STMT_AMTBL_INTEG"; //数据共享账单分期
        public static final String INVIT_ACTIVE_M = "INVIT_ACTIVE_M"; //数据共享促激活
        public static final String INVIT_CAPMT_M = "DXWH_CRCARD_CASH_AMTBL_INTEG"; //数据共享现金分期
        public static final String WHS_REJ_DATA = "WHS_REJ_DATA"; //数据共享退卡重游
        public static final String CTS_CUST_TYPE_INFO = "CTS_WSD_CRS_CMP_CRM_WHT_LS"; //数据共享交叉发卡
        public static final String BUSINESS_FILE_SUFFIX = "xml"; //xml
        public static final String CCD_FENQI_PVALUE = "CCD_FENQI_PVALUE"; //账单分期成功率
        public static final String INVIT_BILPMT_M = "BILPMT_M"; //账单分期月报
        public static final String MARKETING_BLACK = "MARKETING_BLACK"; //营销黑名单
        public static final String PLAN_LIST="PMCTL_PLAN_MANAGE";//积分计划列表
        public static final String ISSU_CARD_SUCC="ISSU_CARD_SUCC";//交叉发卡批卡成功数据
        public static final String SYS_MAP="SYS_REGION_CITY";//电子地图
        public static final String CAS_PAD_JGQL="CAS_PAD_JGQL";//激活结构
        public static final String YX_QUALITY_MARKET_INFO="YX_QUALITY_MARKET_INFO";//悦享发卡文件
        public static final String YX_QUALITY_BY_BILL_INFO="BILL_INSTALLMENT_INFO";//悦享发卡搭销客户信息文件
    }

    /**
     * 定时任务名称
     */
    public static final class TimingTaskRedisKeys {

        public static final String EFTP_DOWNLOAD_TASK_NAME = "eftp_download_task_name"; //下载文件的定时任务名称
        public static final String UPDATE_TASK_CONFIG_NAME = "update_timing_task_config"; //更新定时任务的名称
        public static final String TASK_STATUS_ALL_RECOVERY = "1"; //一键恢复标志

    }

    /**
     * 外拨方式
     */
    public static final class CallType {
        //预测
        public final static int CALL_TYPE_PREDICT = 1;
        public final static String CALL_TYPE_PREDICT_NAME = "预测式外呼";
        //预览
        public final static int CALL_TYPE_PREVIEW = 3;
        public final static String CALL_TYPE_PREVIEW_NAME = "预览式外呼";
        //IVR
        public final static int CALL_TYPE_IVR = 4;
        public final static String CALL_TYPE_IVR_NAME = "IVR外呼";
        //智能
        public final static int CALL_TYPE_SMART = 5;
        public final static String CALL_TYPE_SMART_NAME = "智能外呼";

    }


    /**
     * 数据筛选-分配方式
     */
    public static final class distributeDataType {
        //分配至任务
        public final static String CREATE_TASK = "0";
        //分配至下属机构
        public final static String ALLOCATION_ORGANIZATION = "1";

    }

    /**
     * 数据筛选-分配策略
     */
    public static final class allocationStrategy {
        //按照分期概率排序
        public final static String STAGING_PROBABILITY = "0";
        //按照账单金额排序
        public final static String BILL_AMOUNT = "1";

    }

    /**
     * 数据筛选查-询类型
     */
    public static final class selectType {
        //in
        public final static String IN = "1";
        //betweenAnd
        public final static String BETWEEN_AND = "2";
        //like
        public final static String LIKE = "3";
        //equals
        public final static String EQUALS = "4";
        //likes
        public final static String LIKES = "5";

        public final static String OR = "6";

        public final static String MEITUAN_AND_YINLIAN = "7";

        public final static String QUALITY_PRODUCT="8";

        public final static String OR_LIKES="9";

        public final static String NUM_RANGE = "10";

        public final static String YX_CARD_TYPE = "11";
    }

    /**
     * 业务场景
     */
    public static final class BusinessType {
        //账单分期
        public final static String BUS_TYPE_BILL_INSTALLMENT = "1";
        //现金分期
        public final static String BUS_TYPE_CASH_INSTALLMENT = "2";
        //促激活
        public final static String BUS_TYPE_ASSIST_ACTIVATE = "3";
        //交叉发卡
        public final static String BUS_TYPE_QUALITY_MARKET = "4";
        //交叉发卡新场景
        public final static String NEW_BUS_TYPE_QUALITY_MARKET = "w";
        //退卡重邮
        public final static String BUS_TYPE_RETURN_CARD = "5";
        //通用场景
        public final static String BUS_TYPE_GENERAL = "6";
        //催收
        public final static String BUS_TYPE_DEBT = "7";
        //悦享发卡
        public final static String BUS_TYPE_YX_QUALITY_MARKET = "7";
        //精准营销
        public final static String BUS_TYPE_ACC_MARKET = "a";
        //全业务
        public final static String BUS_TYPE_ALL = "0";
        //账单分期月报
        public final static String BUS_TYPE_BILL_MONTHLY = "8";
        //通用场景_创建ivr任务
        public final static String BUS_TYPE_GENERAL_IVR = "9";
        //营销黑名单数据
        public final static String BUS_TYPE_MARKET_SPECIAL = "s";
        //积分计划列表
        public final static String PLAN_LIST="p";
        //悦享分期激活
        public final static String BUS_TYPE_YX_ASSIST_ACTIVATE = "y";
        //悦享分期激活机构信息
        public final static String YX_ASSIST_ORG_INFO = "org";
        //交叉营销批卡成功
        public final static String BUS_ISSU_CARD_SUCC = "cs";
        //电子地图
        public final static String SYS_MAP = "map";
        //激活机构
        public final static String CAS_PAD_JGQL = "cas";
        //悦享发卡搭销客户信息
        public final static String YX_QUALITY_MARKET_BY_BILL = "7dx";
        //段兴批量发送模板
        public final static String SMS_BATCH_TEMPLATE = "sms";
        //任务状态查询
        public final static String QUERY_STATUS = "status";
    }

    //返回值
    public final static String RET_SUCCESS = "1";
    public final static String RET_ERROR = "-1";

    /**
     * 样本模板常量配置
     */
    public static final class FileTemplate {
        //模板类型 1账单分期/2现金分期/3促激活/4交叉营销发卡/5退卡重邮/6短信/7特殊名单/8通用外呼/9邮件/10催收
        public final static String TEMPLATE_TYPE_BILL_INSTALLMENT = "1";
        public final static String TEMPLATE_TYPE_CASH_INSTALLMENT = "2";
        public final static String TEMPLATE_TYPE_ASSIST_ACTIVATE = "3";
        //交叉发卡
        public final static String TEMPLATE_TYPE_QUALITY_MARKET = "4";
        //交叉发卡新场景
        public final static String TEMPLATE_TYPE_QUALITY_MARKET_NEW = "w";
        public final static String TEMPLATE_TYPE_YX_QUALITY_MARKET = "7";
        public final static String TEMPLATE_TYPE_RETURN_CARD = "5";
        public final static String TEMPLATE_TYPE_SMS = "6";
        public final static String TEMPLATE_TYPE_SPECIAL_LIST = "s";
        public final static String TEMPLATE_TYPE_GENERAL = "8";
        public final static String TEMPLATE_TYPE_EMAIL = "9";
        public final static String TEMPLATE_TYPE_DEBT = "10";
        public final static String TEMPLATE_TYPE_WORK_ORDER_THE_FEES = "11";
        public final static String TEMPLATE_TYPE_YX_ASSIST_ACTIVATE = "y";
    }

    /**
     * 操作类型
     */
    public static final class OperateType {
        //操作流水记录操作类型 1座席端/2管理端
        public final static String OPERATE_CHANNEL_AGENT = "1";
        public final static String OPERATE_CHANNEL_MANAGER = "2";
    }

    /**
     * 交叉发卡页面操作类型
     */
    public static final class QualityOperateType {
        public final static String QUALITY_SAVE = "save";//暂存
        public final static String QUALITY_SUBMIT = "submit";//提交
    }

    /**
     * 行政机构
     */
    public static final class GetOrgByParentId {
        public final static String DEPARTMENT = "department";//行政机构
        public final static String PARENT = "parent";
        public final static String DATATYPE_DEPTGROUP = "DeptGroup";
        public final static String SYSTEM_CODE = "MCC-MCSR-OUTBOUND";
    }

    /**
     * 黑名单状态
     */
    public static final class BlackList {

        public final static String BLACKLIST_STATUS_VALID = "1";    //有效
        public final static String BLACKLIST_STATUS_INVALID = "0";  //无效
        public final static String BLACKLIST_STATUS_APPRO = "2";    //待审批

    }

    /**
     * 性别
     */
    public static final class Sex {

        public final static String MALE = "1";    //男
        public final static String MALE_VALUE = "男";    //男
        public final static String FEMALE = "2";  //女
        public final static String FEMALE_VALUE = "女";  //女
        public final static String UNKNOW = "3";  //未知
        public final static String UNKNOW_VALUE = "未知";  //未知
    }

    /**
     * 是否
     */
    public static final class WhetherList {

        public final static String WHETHERLIST_YES = "1";    //是
        public final static String WHETHERLIST_NO = "0";  //否

    }


    /**
     * 是否关联自动还款
     */
    public static final class IsAutoRepay{
        public final static String SUCCESS = "已关联自动还款";
    }

    /**
     * 业务总状态
     */
    public static final class BusinessStatus {

        public final static String TO_BE_PROCESSED = "0";    //待处理
        public final static String COMPLETED = "1";  //已完成
        public final static String BILL_COMPLETED_VALUE = "已申请账单分期";  //账单分期业务完成备注
        public final static String CASH_COMPLETED_VALUE = "已申请现金分期";  //现金分期业务完成备注
        public final static String ASSIST_COMPLETED_VALUE = "已激活卡";  //促激业务完成备注
        public final static String RETURN_CARD_VALUE = "已完成退卡重邮";  //已完成退卡重邮
        public final static String YXSTAGE_COMPLETED_VALUE = "已申请悦享分期";  //悦享分期业务完成备注

    }

    /**
     * 业务最新状态
     */
    public static final class BusinessNowStatus {

        // 1无小结、 3已预约、 0拒绝  4办理成功
        public final static String REFUSED = "0"; //0拒绝
        public final static String REFUSED_VALUE = "拒绝"; //0拒绝
        public final static String NOT_INTE = "1";  //1无小结
        public final static String NOT_INTE_VALUE = "暂无小结";
        public final static String GENERAL_CALL_SUCCESS = "2";  //2通用外呼打电话完成
        public final static String GENERAL_CALL_SUCCESS_VALUE = "通用外呼打电话完成";
        public final static String WAS_BOOKED = "3";  //3已预约
        public final static String WAS_BOOKED_VALUE = "预约";  //3已预约
        public final static String SUCCESSFULLY_PROCESSED = "4";    //4办理成功
        public final static String SUCCESSFULLY_PROCESSED_VALUE = "办理成功";    //4办理成功
        public final static String SEN_FAIL = "F";    //下发失败
        public final static String SEN_FAIL_VALUE = "下发失败";
        public final static String ASSIGN_DATA = "5";    //
        public final static String ASSIGN_DATA_VALUE = "此条数据已被指定数据处理";    //5 指定数据
        public final static String QUALITYMARKET_NOTCONFIRMED = "6";  // 交叉发卡数据进入待确认名单
        public final static String QUALITYMARKET_NOTCONFIRMED_VALUE = "交叉发卡数据已进入待确认名单";
        public final static String SUCCESSFULLY = "7";  //业务已办理未小结
        public final static String SUCCESSFULLY_VALUE = "业务已办理";

        public final static String RETURN_ADDRESS_REVISE = "8";    //8 退卡重邮修改地址
        public final static String RETURN_ADDRESS_REVISE_VALUE = "退卡重邮修改地址";
        public final static String RETURN_ADDRESS_UNCHANGE = "9";    //9 退卡重邮不修改地址
        public final static String RETURN_ADDRESS_UNCHANGE_VALUE = "退卡重邮不修改地址";

        public final static String YX_QUALITY_REFUSE = "B";    //B 悦享分期卡申请被拒
        public final static String YX_QUALITY_REFUSE_VALUE = "信用卡申请被拒绝";

        public final static String REFUSE_NO_CONNECTED="多次未接通";
        public final static String REFUSE_NO_MARKET="无办卡意愿";
        public final static String REFUSE_OTHER="其他";
        public final static String CALLED_TWO_TIMES = "A";  //待确认列表二次外呼
        public final static String CALLED_TWO_TIMES_VALUE = "已由待确认列表二次外呼"; //待确认列表二次外呼
    }

    /**
     * 最新呼叫状态
     */
    public static final class BusinessCallStatus {

        public final static String WAS_NOT_DIALED = "0";
        public final static String WAS_NOT_DIALED_VALUE = "未拨打";    //0未拨打
        public final static String WAS_NOT_CONNECTED = "1";  //1未接通
        public final static String WAS_NOT_CONNECTED_VALUE = "未接通";  //1未接通
        public final static String WAS_CONNECTED = "2";    //2已接通
        public final static String WAS_CONNECTED_VALUE = "已接通";    //2已接通
        public final static String CALL_LOSS = "3";    //3呼损
        public final static String CALL_LOSS_VALUE = "呼损";    //3呼损
        public final static String CALL_LOSS_APPOINT = "已预约";    //4已预约
        public final static String CALL_LOSS_APPOINT_VALUE = "4";    //4已预约
        public final static String CALL_AGENT_LOSS = "5";    //5 客户接起 坐席未接起
        public final static String CALL_FILTER="13"; //账单金额过滤数据
        public final static String CALL_FILTER_VALUE="账单金额过滤数据";
    }

    /**
     * 业务场景查询条件名称
     */
    public static final class BusinessQueryNames {

        public final static String SUMMARY_STATUS = "summaryStatus"; //最新小结状态
        public final static String USER_NO = "userNo";    //用户编号
        public final static String TASK_STATUS = "taskStatus";  //任务状态
        public final static String ORG_NO = "orgNo";  //部门编号
        public final static String TIME = "time";  //时间
        public final static String CALL_STATUS = "callStatus";  //拨号状态
        public final static String NOW_STATUS = "nowStatus";  //业务状态
        public static final String IS_OVER = "isOver"; //case状态 1正常
        public static final String IS_JOIN_BLACKLIST = "blackListStatus"; //黑名单状态
        public static final String IS_VALID = "validStatus"; //有效状态 1有效
        public static final String IS_RECYCLE = "recycleStatus"; //回收状态 1正常
        public static final String CARD_NO = "cardNo"; //卡号
        public static final String ID_CARD_NO = "idCardNo"; //身份证
        public static final String PHONE = "phone"; //手机号
    }

    /**
     * 查询类型
     */
    public static final class BusinessQueryType {
        //查找方式 1精确 2模糊 3不查 4 !=
        public final static String ACCURATE = "1"; //精确
        public final static String LIKE = "2";    //模糊
        public final static String NO_QUERY = "3";  //不查
        public final static String NO_EQUAL = "4";  //不等于

    }

    /**
     * 知识库类型 1公共知识库 2内部知识库 3质检文件库
     * private Integer knowType;
     */
    public static final class knowType {
        //查找方式 1精确 2模糊 3不查 4 !=
        public final static String GENERAL = "1"; //公共知识库
        public final static String GENERAL_VALUE = "公共知识库"; //精确
        public final static String INNER = "2";    //内部知识库
        public final static String INNER_VALUE = "内部知识库";    //内部知识库
        public final static String INSPECTION = "3";  //质检知识库
        public final static String INSPECTION_VALUE = "质检知识库";  //质检知识库
    }

    /**
     * 排序方式
     */
    public static final class BusinessSortType {
        public final static String AMOUNT = "amount"; //金额
        public final static String CDATE = "cDate";    //创建时间
        public final static String UPDATE = "upDate";  //更新时间

    }


    /**
     * 认证状态
     */
    public static final class AuthStatus {

        public final static Short SUCCESS = 1; //认证成功
        public final static Short FAIL = -1;    //失败
        public final static Short CERTIFICATION = 0;  //认证中

    }

    /**
     * 电销状态
     */
    public static final class SalesHistory {

        public final static String SUCCESSFUL_HANDLING = "1"; //成功办理
        public final static String REFUSAL = "-1";    //拒绝办理
        public final static String SUCCESSFUL_HANDLING_VALUE = "成功办理"; //成功办理
        public final static String REFUSAL_VALUE = "拒绝办理";    //拒绝办理

    }

    /**
     * 现金分期类型
     */
    public static final class CashType {

        public final static String WITHIN = "1"; //现金分期额度内
        public final static String CASH_OUT_OF = "2";    //现金分期额度外

    }

    /**
     * 申请分期状态
     */
    public static final class ApplyStageList {

        public final static String CANCELLATION = "0";    //撤销
        public final static String NORMAL = "1"; //正常
        public final static String NORMAL_PAYMENT = "2"; //正常还完
        public final static String SUCCESSFUL_EARLY_PAYMENT = "3"; //申请提前还款

    }


    /**
     * 是否有效
     */
    public static final class IsVaild {

        public final static String VAILD = "1";    //有效
        public final static String NO_VAILD = "0"; //失效


    }

    /**
     * 是否创建任务
     */
    public static final class IsTask {

        public final static String TASKED = "1";    //创建任务
        public final static String NO_TASK = "0"; //未创建任务


    }

    /**
     * 是否回收
     */
    public static final class IsRecycle {

        public final static String RECYCLED = "1";    //已回收
        public final static String NO_RECYCLE = "0"; //未回收


    }

    /**
     * 数据源
     */
    public static final class DataSource {

        public final static String MANUAL_IMPORT = "1";//手动导入
        public final static String AUTO_IMPORT = "0"; //自动导入
        public final static String TASK_MANAGER_BUTTON = "3"; //任务管理中导入数据


    }

    /**
     * 导入状态  //导入状态 0 导入异常 1正在导入 2导入完成
     */
    public static final class ImportStatus {

        public final static String IMPORT_EXCEPTION = "0";//导入异常
        public final static String IMPORTING = "1"; //正在导入
        public final static String IMPORT_FINISH = "2"; //导入完成
        public final static String IMPORT_DOWNLOADED = "3"; //已下载

    }

    /**
     * 导出状态
     */
    public static final class ExportStatus {

        public final static String EXPORT_EXCEPTION = "0";//导出异常
        public final static String EXPORTING = "1"; //正在导出
        public final static String EXPORT_FINISH = "2"; //导出完成
        public final static String EXPORT_DOWNLOADED = "3"; //已下载

    }

    public static final class PrprdName {
        public final static String CASH_NAME = "额度内现金分期";
        public final static String BILL_NAME = "额度内现金分期";
    }

    /**
     * 条数类型
     */
    public static final class CountType {
        //全部
        public final static String ALL = "1";
        //百分数
        public final static String PERCENTAGE = "2";
        //条数
        public final static String COUNT = "3";

    }

    /**
     * 是否总中心
     */
    public static final class HeadOrgNo {

        public final static String ORG_NO = "ZZX";//总中心

    }

    public static final class WkTransferType {
        public final static String AGENT_TRANSFER = "1";
        public final static String INSIDE_TRANSFER = "2";
        public final static String TRANSFER_AGENT = "3";
    }

    public static final class WkTransferStatus {
        public final static Integer INIT_STATUS = 0;
        public final static Integer ASSIGNED_STATUS = 1;
        public final static Integer DEAL_STATUS = 2;
        public final static Integer DRAW_STATUS = 3;
        public final static Integer OVER_STATUS = 4;
        public final static Integer TIMEOUT_STATUS = 5;
    }

    /**
     * 联系状态
     */
    public static final class CallState {

        public final static String UNCALL = "0"; //未呼叫

        public final static String UNCONNECTED = "1";//未接通

        public final static String CONNECTED = "2"; //已接通

        public final static String CALL_LOSS = "3"; //呼损

        public final static String CALL_APPOINT = "4"; //已预约

    }

    /**
     * 小结状态
     */
    /*public static final class SummaryStatus {

        public final static String REFUSE = "1"; //拒绝

        public final static String APPOINTMENT = "2"; //预约

        public final static String SUCCESS = "3";   //办理成功

        public final static String ASSIGNED_DATA = "4";//指定数据

    }*/

    /**
     * 是否结案
     */
    public static final class CASE_IS_OVER {

        public final static String NOT_OVER = "1";//未结案

        public final static String OVER = "0";//结案

    }

    /**
     * 是否执行
     */
    public static final class IsExecute {

        public final static String EXECUTED = "1";        //已执行

        public final static String UNEXECUTED = "0"; //未执行
    }

    /**
     * 是否指定数据
     */
    public static final class IsAppoint {

        public final static String APPOINTED = "1";//已指定

        public final static String UNAPPOINTED = "0";//未指定

    }

    /**
     * 预约-是否正常
     */
    public static final class IsNormal {

        public final static String NORMAL = "1"; //正常

        public final static String EXCEPTION = "0";//异常

        public final static String DROP = "2";//删除

    }

    /**
     * 预约- 是否为最新预约
     */
    public static final class IsNow {

        public final static String NOW = "1"; //最新预约

        public final static String UN_NOW = "0";//非最新预约

        public final static String DEL_NOW = "2";//非最新预约

    }

    /**
     * 黑名单状态
     */
    public static final class SpecialListStatus {

        public final static String UN_VALID = "1"; //失效
        public final static String UN_VALID_NAME = "已失效"; //失效

        public final static String VALID = "0";//有效
        public final static String VALID_NAME = "已生效";//有效

        public final static String PENDING_APPROVAL = "2";//待审批
        public final static String PENDING_APPROVAL_NAME = "待审批";//待审批

    }

    /**
     * 是否强制执行
     */
    public static final class IsForce {
        //强制执行
        public final static String FORCE = "1";
        //非强制执行
        public final static String UN_FORCE = "0";
    }


    /**
     * 工单状态码的解释
     */
    public final class WorkOrderStatus {

        public final static String INITIAL = "初始化";
        public final static int INITIAL_NO = 0;

        public final static String CIRCULATION = "已流转";
        public final static int CIRCULATION_NO = 1;

        public final static String HANDLED = "已处理";
        public final static int HANDLED_NO = 2;

        //public final static String CANCEL = "已撤回";
        public final static String WAIT_HANDLED = "待提交";
        public final static int WAIT_HANDLED_NO = 3;

        public final static String FINISH = "已结束";
        public final static int FINISH_NO = 4;

        public final static String WARNING = "已预警";
        public final static int WARNING_NO = 5;

        public final static String UNKNWON = "未知状态";

        public final static String STORAGE = "暂存";
        public final static int STORAGE_NO = 6;

        public final static String ALLOCATED = "已分配";
        public final static int ALLOCATED_NO = 7;

        public final static String WITHDRAW = "已撤回";
        public final static int WITHDRAW_NO = 8;

        public final static String EXPIRED = "已过期";
        public final static int EXPIRED_NO = 9;
    }


    /**
     * 数据导入开关 --- 是否匹配数据库数据
     */
    public static final class IsMatchPoolData {

        public final static String IS_MATCH = "1";// 0不匹配 1匹配
    }

    /**
     * 短信邮件记录类型
     */
    public static final class SMS_Email_Type {

        public final static String EMAIL_TYPE = "1"; //邮件
        public final static String SMS_TYPE = "0"; //短信
    }

    /**
     * 短信发送类型
     */
    public static final class SMSSendType {

        public final static String SMS_SEND = "1"; //普通
        public final static String CODE_SEND = "2"; //短信验证码
    }

    /**
     * 业务短信拼接内容
     */
    public static final class SmsJointContent {

        public final static String SMS_UNSUBSCRIBE = "退订请回复[TD]";

    }

    /**
     * 业务短信拼接内容
     */
    public static final class SmsBusinessCode {
        public final static String SMS_VERIFICATION = "237_XYKDXWH_001";
        public final static String SMS_REMIND = "237_XYKDXWH_002";
        public final static String SMS_BUSINESS = "237_XYKDXWH_003";
    }

    /**
     * OCS推送的数据通话结果类型
     */
    public static final class OcsStatus {

        public final static Integer CALL_UNTREATED = 0; //未处理
        public final static Integer CALL_USER_SIPCALLEEBUSY = 1; //用户忙
        public final static Integer CALL_USER_REJECT = 2; //用户拒绝
        public final static Integer CALL_CONNECTING = 3; //未接通坐席前用户弃话
        public final static Integer CALL_ABSENTEE = 4; //空号
        public final static Integer CALL_USER_RESPOND = 5; //用户未响应
        public final static Integer CALL_BUSY = 6; //坐席忙
        public final static Integer CALL_SEATS_REJECT = 7; //坐席拒接
        public final static Integer CALL_SUCCESS = 8; //外呼成功
        public final static Integer CALL_ERROR = 9; //未知错误
        public final static Integer CALL_OVER = 10; //无坐席可用挂断
        //public final static Integer CALL_OVER = 11; //系统挂机
        public final static Integer CALL_FILTER = 13;//无效号码
        //public final static Integer CALL_FILTER = 20;//关机
        //public final static Integer CALL_FILTER = 21;//停机

    }

    /**
     * 参数code
     */
    public static final class ParamCode {

        public static final String FILE_SERVER_URL = "fileserver_url";
    }


    /**
     * 数据共享文件上传状态
     */
    public static final class UploadStatus {
        public static final String SUCCESS = "1"; //  成功
        public static final String ERROR = "0"; //失败
    }

    /**
     * 证件编号
     */
    public static final class IdCode {
        public static final String ID_CARD_VAL = "01";//socket
        public static final String JM_CARD = "身份证";
        public static final String JM_CARD_VAL = "10";//http
        public static final String LS_CARD = "11";
        public static final String JR_CARD = "20";
        public static final String SB_CARD = "21";
        public static final String JUNG_CARD = "22";
        public static final String WZ_CARD = "23";
        public static final String JGT_CARD = "24";
        public static final String WZT_CARD = "25";
        public static final String WJ_CARD = "30";
        public static final String WJSB_CARD = "31";
        public static final String JINGG_CARD = "32";
        public static final String WJWZ_CARD = "33";
        public static final String WJJGT_CARD = "34";
        public static final String WJWZT_CARD = "35";
        public static final String HK_CARD = "40";
        public static final String BG_CARD = "50";
        public static final String WG_CARD = "51";
        public static final String GAT_CARD = "60";
        public static final String TW_CARD = "61";
        public static final String BJ_CARD = "62";
        public static final String WGYJ_CARD = "70";
        public static final String QT_CARD = "99";
    }


    /**
     * 地址编码
     */
    public static final class StsMail {
        //家庭
        public static final String HOME_ADDR = "H";
        //公司
        public static final String COMPANY_ADDR = "B";
        //户籍
        public static final String CENSUS_ADDR = "F";
        //房产
        public static final String ESTATE_ADDR = "W";
        //担保人单位
        public static final String GU_ADDR = "G";
        //担保人地址
        public static final String GA_ADDR = "P";
        //学校
        public static final String SCHOOL_ADDR = "S";
    }

    /**
     * 是否设置交易密码
     */
    public static final class IsSet {
        //已设置交易密码
        public final static String setTrue = "1";
        //未设置交易密码
        public final static String setFalse = "0";
    }


    public static final class IvrResult {
        //客户同意办理
        public final static String IVR_YES = "3";
        public final static String IVR_YES_VAL = "客户同意办理";
        //客户不需要办理
        public final static String IVR_NO = "4";
        public final static String IVR_NO_VAL = "客户不需要办理";
        //电话呼损
        public final static String IVR_LINK_FAIL = "2";
        public final static String IVR_LINK_FAIL_VAL = "电话呼损";
        //电话未接通
        public final static String IVR_UNLINK = "1";
        public final static String IVR_UNLINK_VAL = "电话未接通";
        //电话未接通
        public final static String IVR_KEY = "5";
        public final static String IVR_KEY_VAL = "按键丢失";
    }

    public final static Integer valueMonth = 2;

    public static final class UpdAddrFlag {
        public final static String UPD_ADDR = "1";
        public final static String UPD_ADDR_VAL = "修改地址";

        public final static String UNUPD_ADDR = "0";
        public final static String UNUPD_ADDR_VAL = "不修改地址";
    }


    public static final class RedisKeyType {
        public final static String BILL_Installment = "zdfq_";
        public final static String ASSIST_Installment = "cjh_";
        public final static String YXASSIST_Installment = "yxjh_";
        public final static String QUALITY_MARKET = "quality_";
        public final static String QUALITY_MARKET_NEW = "qualityNew_";
        public final static String YX_QUALITY_MARKET = "yxquality_";
        public final static String ACCURATE_MARKET = "accMarket_";
    }


    public static final class BusinessName {
        public final static String BILL_INSTALLMENT = "账单分期";
        public final static String CASH_INSTALLMENT = "现金分期";
        public final static String ASSIST_ACTIVATE = "促激活";
        public final static String YX_ASSIST_ACTIVATE = "悦享分期";
        public final static String QUALITY_MARKET = "交叉发卡";
        public final static String QUALITY_MARKET_NEW = "交叉发卡电销+直销";
        public final static String YX_QUALITY_MARKET = "悦享发卡";
        public final static String RETURN_CARD = "退卡重邮";
        public final static String PUBLIC = "公共";
        public final static String GENERAL = "通用外呼";
        public final static String ACC_MARKET = "精准营销";
    }



    /**
     * 违纪单状态/审批状态   --违纪单
     */
    public static final class Status {
        public static final String DELETED = "0"; //已删除
        public static final String WAIT_HANDLE = "1"; //待处理
        public static final String HANDLED = "2"; //已处理
        public static final String STORAGE = "3";  //暂存中
        public static final String END = "4";  //结束
        public static final String UN_ISSUE = "5";  //未下发
    }


    /**
     * 意见   --违纪单
     */
    public static final class Opinion {
        public static final String AGREE = "同意";
        public static final String DISAGREE = "不同意";
    }

    /**
     * 意见说明/复议内容   --违纪单
     */
    public static final class IllustrateType {
        public static final String OPINION_DETAIL = "意见详情";
        public static final String RECONSIDER_CONTENT = "复议内容";
    }

    /**
     * 违纪单操作场景 --违纪单
     */
    public static final class Scene {
        public static final String ISSUE = "1"; //违纪单下发场景
        public static final String REVIEW = "2";//违纪单复核场景
        public static final String HANDLE = "3";//违纪单处理场景
        public static final String SELECT = "4";//违纪单查询场景
    }

    /**
     * 违纪单操作按钮类型  --违纪单
     */
    public static final class ButtonType {
        public static final String READ = "1"; //只读
        public static final String EDIT = "2";//编辑
        public static final String DELETE = "3";//删除
    }

    /**
     * 页面类型  --违纪单
     */
    public static final class PageType {
        public static final String UPDATE_DISCIPLINE_ORDER_PAGE = "1"; //可修改违纪单详情页面
        public static final String EDIT_OPINION_PAGE = "2";//可修改或填写意见页面
    }

    /**
     * 请求头参数
     */
    public static final String REGISTRATION_LOCATION = "attribution_";
    public static final String REQUEST_DOWNLOAD_HEADER = "request-download-header";
    public static final String REQUEST_DOWNLOAD_HEADER_VALUE = "request-download-header-value";

    public static final String REQUEST_UPLOAD_HEADER = "request-upload-header";
    public static final String REQUEST_UPLOAD_HEADER_VALUE = "request-upload-header-value";


    public static final class BaseVariable {
        public static final String ONE = "1";
        public static final String TWO = "2";
        public static final String THERR = "3";

    }


    /**
     * 卡片渠道（银联/美团）
     */
    public static final class cardTagType {
        //银联
        public final static String CARD_TAG_UN = "1";
        //美团
        public final static String CARD_TAG_MEITUAN = "2";

    }

    /**
     * 卡片渠道（银联/美团）
     */
    public static final class cardTagValue {
        //银联
        public final static String CARD_TAG_UN = "银联";
        //美团
        public final static String CARD_TAG_MEITUAN = "美团";

    }

    /**
     * 渠道地址(新/旧)
     */
    public static final class ipFlag {
        //银联
        public final static String IP_OLD = "old";
        //美团
        public final static String IP_NEW = "new";

    }

    public static final class requestFlag{
        //获取三要素
        public final static String IMP_FIELD="1";
        //获取所有字段
        public final static String ALL_FIELD="2";

    }

    public static final class systemFlag{
        //获取三要素
        public final static String OUTBOUND="dx";
        public final static String OUTBOUND_NAME="电销外呼系统";
        //获取所有字段
        public final static String ONLINE="xs";
        public final static String ONLINE_NAME="线上发卡系统";
    }
    //交叉发卡客户类型对应关系
    public static final class QualityCustType{
//        //代发
//        public final static String TYPE1="1";
//        public final static String TYPENAME1="代发";
//        //贷款
//        public final static String TYPE2="2";
//        public final static String TYPENAME2="贷款";
//        //投资
//        public final static String TYPE3="3";
//        public final static String TYPENAME3="投资";
//        //VIP
//        public final static String TYPE4="4";
//        public final static String TYPENAME4="VIP";
//        //其它
//        public final static String TYPE5="5";
//        public final static String TYPENAME5="其它";
          //花呗
          public final static String TYPE1="1";
          public final static String TYPENAME1="花呗";
          //手机银行断点
          public final static String TYPE3="3";
          public final static String TYPENAME3="手机银行断点";
          //达标未领取权益客户
          public final static String TYPE4="4";
          public final static String TYPENAME4="达标未领取权益客户";
          //悦享分期交叉白名单
          public final static String TYPE5="5";
          public final static String TYPENAME5="悦享分期交叉白名单";
          //经营贷
          public final static String TYPE6="6";
          public final static String TYPENAME6="经营贷";
          //信贷
          public final static String TYPE7="7";
          public final static String TYPENAME7="信贷";
          //信贷
          public final static String TYPE8="8";
          public final static String TYPENAME8="短信断点";
    }
    //交叉发卡营销优先级对应关系
    public static final class QualityMarketLevel{
        //极高
        public final static String VALUE1="1";
        public final static String LEVEL1="极高";
        //高
        public final static String VALUE2="2";
        public final static String LEVEL2="高";
        //较低
        public final static String VALUE3="3";
        public final static String LEVEL3="较低";
        //低
        public final static String VALUE4="4";
        public final static String LEVEL4="低";
    }

    /**
     * 分期协议模板id
     */
    public static final class AgreeTemplate{
        //账单分期模板
        public final static String BILL_TEMPLATE="SP005104";
        //现金分期模板
        public final static String CASH_TEMPLATE="SP005103";
        //悦享分期模板
        public final static String YXAS_TEMPLATE="SP005105";
    }

    /**
     * 分期协议模板公共参数
     */
    public static final class AgreeParams{
        //产品号
        public final static String PRODUCT_NO="SP0051";
        //签章交易代码
        public final static String SIGNATURE_NO="SP005101";
        //签章机构号
        public final static String SIGNATURE_INST_NO="11005293";
    }

    /**
     * 柜员号
     */
    public static final class TellerCode{
        public final static String BILL_CODE="20201112540";
        public final static String CASH_CODE="20210716510";
        public final static String YXAS_CODE="20211109670";
    }

    /**
     * 悦享发卡虚拟卡状态
     */
    public static final class YxQualityCardStatus{
        //未进件
        public final static String CARD_NONE ="0";
        //已进件未激活
        public final static String ACTIVED_NONE ="1";
        public final static String YX_ACTIVED_NONE_VALUE = "已进件未激活"; //悦享发卡业务备注
        //已激活未分期
        public final static String STAGE_NONE ="2";
        public final static String YX_STAGE_NONE_VALUE = "已激活未分期";  //悦享发卡业务备注
        //已分期
        public final static String STAGE ="3";
        public final static String YX_STAGE_VALUE = "已分期";  //悦享发卡业务备注
    }
    /**
     * 任务状态appid对应的业务场景id
     */
    public static final class TaskAppId{
        public final static String bill_app_id="bill_app_id" ; //账单分期
        public final static String cash_app_id="cash_app_id"; //现金分期
        public final static String ass_app_id ="ass_app_id"; //促激活
        public final static String yx_quality_app_id ="yx_quality_app_id";//悦享发卡
        public final static String acc_app_id ="acc_app_id"; //精准营销
        public final static String quality_app_id ="quality_app_id";//交叉发卡新场景
    }

    /**
     * 交叉发卡智能短信策略
     */
    public static final class StgyTypeCode{
        //转人工失败策略
        public final static String ARTIFICIAL_NONE ="1";
        public final static String ARTIFICIAL_NONE_VALUE = "转人工失败策略";
        //未接通策略
        public final static String BUSY_NONE ="2";
        public final static String BUSY_NONE_VALUE = "未接通策略";
        //标签策略
        public final static String LABEL ="3";
        public final static String LABEL_VALUE = "标签策略";
    }
}

