package com.its.member.entity;

import com.its.member.dto.BoardDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="board_test_table")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String board_writer;

    @Column(length = 50, nullable = false)
    private String board_title;

    @Column(length = 500)
    private String board_contents;

    @Column
    private int board_hits;

    @Column(updatable = false)
    private LocalDateTime board_created_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private MemberEntity member;

//    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
//        BoardEntity boardEntity = new BoardEntity();
//        boardEntity.setBoard_writer(boardDTO.getBoard_writer());
//        boardEntity.setBoard_title(boardDTO.getBoard_title());
//        boardEntity.setBoard_contents(boardDTO.getBoard_contents());
//        boardEntity.setBoard_hits(0);
//        return boardEntity;
//    }

    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoard_title(boardDTO.getBoard_title());
        boardEntity.setBoard_writer(boardDTO.getBoard_writer());
        boardEntity.setBoard_contents(boardDTO.getBoard_contents());
        boardEntity.setBoard_hits(0);
        return boardEntity;
    }
}
