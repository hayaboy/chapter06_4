package com.chapter06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chapter06.domain.Board;
import com.chapter06.persistence.BoardRepository;


@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepo;

	@Override
	public List<Board> getBoardList(Board board) {
		
		return (List<Board>) boardRepo.findAll();
	}

	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);  //매개변수로 받은 엔티티를 BoardRepository의 save()를 통해 영속화하는 것
		
	}

	@Override
	public Board getBoard(Board board) {
		
		return boardRepo.findById(board.getSeq()).get();
	}

	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}

	@Override
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
		
	}

}

