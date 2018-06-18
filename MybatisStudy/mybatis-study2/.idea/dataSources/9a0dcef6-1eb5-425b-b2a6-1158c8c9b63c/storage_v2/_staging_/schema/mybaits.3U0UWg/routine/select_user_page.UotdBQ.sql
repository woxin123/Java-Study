DROP PROCEDURE if exists select_user_page;
create procedure select_user_page(IN userName varchar(50), IN `_offset` bigint, IN `_limit` bigint, OUT total bigint)
  BEGIN
  # 查询总数
  SELECT count(*) INTO total
  FROM sys_user
    WHERE user_name LIKE concat('%', userName, '%');
  # 分页查询
  SELECT *
    FROM sys_user
    WHERE user_name LIKE concat('%', userName, '%')
  LIMIT _offset, _limit;
end;

