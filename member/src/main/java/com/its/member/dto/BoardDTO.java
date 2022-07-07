package com.its.member.dto;

import com.its.member.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long id;
    private String board_writer;
    private String board_title;
    private String board_contents;
    private int board_hits;
    private LocalDateTime board_created_time;

    public BoardDTO(String board_title, String board_writer, String board_contents) {
        this.board_title = board_title;
        this.board_writer = board_writer;
        this.board_contents = board_contents;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoard_writer(boardEntity.getBoard_writer());
        boardDTO.setBoard_contents(boardEntity.getBoard_contents());
        boardDTO.setBoard_hits(boardEntity.getBoard_hits());
        boardDTO.setBoard_created_time(boardEntity.getBoard_created_time());
        return boardDTO;
    }
}
