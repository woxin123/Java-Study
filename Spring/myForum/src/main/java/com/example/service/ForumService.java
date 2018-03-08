package com.example.service;

import com.example.dao.BoardMapper;
import com.example.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {

    private BoardMapper boardMapper;

    @Autowired
    public void setBoardMapper(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<Board> getAllBoard() {
        return boardMapper.getAllBoard();
    }
}
