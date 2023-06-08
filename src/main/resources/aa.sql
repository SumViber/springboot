INSERT INTO timing_task ("timing_task_id", "timing_task_no", "timing_task_name", "timing_task_execute_time",
                           "lock_tov", "created_date", "update_date", "update_user_no", "update_user_name", "lock_key",
                           "version", "remarks")
VALUES (51, '编号51', 'report_ocs_dayend_update_call_status_task_name', '0 2 0 * * ?', '1200', '2023-06-05 09:48:00',
        '2023-06-05 09:48:00', '90016', 'XA管理员', 'report_ocs_dayend_update_call_status_redis_key', 1,
        '(报表)日终同步通话状态');


