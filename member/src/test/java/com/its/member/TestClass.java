package com.its.member;

import com.its.member.dto.BoardDTO;
import com.its.member.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestClass {
    @Autowired
    private BoardService bs;

    @Test
    @Transactional
    @Rollback
    public void saveTest() {
        String testTitle = "test 제목";
        String testWriter = "test 작성자";
        String testContents = "test 내용";

        Long saveId = bs.save(new BoardDTO(testTitle, testWriter, testContents));
        String boardWriter = bs.findById(saveId).getBoard_writer();
        assertThat(testWriter).isEqualTo(boardWriter);
    }
}
