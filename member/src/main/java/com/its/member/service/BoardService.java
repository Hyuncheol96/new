package com.its.member.service;

import com.its.member.dto.BoardDTO;
import com.its.member.entity.BoardEntity;
import com.its.member.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository br;

    public Long save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        Long saveId = br.save(boardEntity).getId();
        return saveId;
    }
    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = br.findById(id);
        if (optionalBoardEntity.isPresent()) {
            BoardDTO boardDTO = BoardDTO.toBoardDTO(optionalBoardEntity.get());
            return boardDTO;
        } else {
            return null;
        }
    }
    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = br.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity board: boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(board));
        }
        return boardDTOList;
    }
}
