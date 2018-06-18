create procedure select_user_by_id(IN  userId    bigint, OUT userName varchar(50), OUT userPassword varchar(50),
                                OUT userEmail varchar(50), OUT userInfo text, OUT headImg blob, OUT createTime datetime)
  BEGIN
  # 根据用户id查询其他数据
  SELECT user_name, user_password, user_email, user_info, head_img, create_time
    INTO userName, userPassword, userEmail, userInfo, headImg, createTime
  FROM sys_user
  WHERE id = userId;
end;

