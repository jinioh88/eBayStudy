package com.example.myboard.service;

import com.example.myboard.Repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardServiceTest {
    @Autowired
    BoardService service;

    @Test
    public void searchTest() throws Exception {
        PageRequest pageRequest = PageRequest.of(0,3);
        service.getBoards(1);
    }
}
