DROP PROCEDURE IF EXISTS insert_user_and_roles;
create procedure insert_user_and_roles(OUT userId     bigint, IN userName varchar(50), IN userPassword varchar(50),
                                       IN  userEmail  varchar(50), IN userInfo varchar(50), IN headImg blob,
                                       OUT createTime datetime, IN roleIds varchar(200))
  BEGIN
  # 设置当前时间
  SET createTime = NOW();
  # 插入数据
  INSERT INTO sys_user(user_name, user_password, user_email, user_info,
    head_img, create_time)
    VALUES (userName, userPassword, userEmail, userInfo, headImg, createTime);
  # 获取自增主键
  SELECT LAST_INSERT_ID() INTO userId;
  # 保存用户和角色关系数据
  SET roleIds = CONCAT(',', roleIds, ',');
  SELECT userId, id FROM sys_role
    WHERE INSTR(roleIds, CONCAT(',', id, ',')) > 0;
end;

