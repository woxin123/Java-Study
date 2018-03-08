package com.example.dao;

import com.example.domain.Board;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

    @Select("SELECT * FROM t_board")
    @Results(id = "boardMap", value = {
            @Result(id = true, column = "board_id", property = "boardId"),
            @Result(column = "board_name", property = "boardName"),
            @Result(column = "board_desc", property = "boardDesc"),
            @Result(column = "topic_num", property = "topicNum")
    })
    List<Board> getAllBoard();
}
