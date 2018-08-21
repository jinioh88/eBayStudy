package com.example.myboard.service;

import com.example.myboard.domain.Board;
import org.springframework.data.domain.Page;


public interface BoardService {
    public Board addBoard(Long memberId, Board board); // 로그인한 정보로 memberId를 받는다.
    public Page<Board> getBoards(int page);
    public Page<Board> getBoardsByTitle(String title,int page);
}
