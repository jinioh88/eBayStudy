package com.example.myboard.service.impl;

import com.example.myboard.Repository.BoardRepository;
import com.example.myboard.Repository.MemberRepository;
import com.example.myboard.domain.Board;
import com.example.myboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    @Transactional
    public Board addBoard(Long memberId, Board board) {

        return board;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoards(int page) {
        PageRequest pageRequest = PageRequest.of(page-1, 5);
        Page<Board> boardPage = boardRepository.findAllBy(pageRequest);
        return null;
    }

    @Override
    public Page<Board> getBoardsByTitle(String title,int page) {
        PageRequest pageRequest = PageRequest.of(page-1,5);
        Page<Board> boardPage = boardRepository.findAllByTitleContains(title,pageRequest);
        return null;
    }
}
