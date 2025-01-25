package io.goorm.mybatis.api.board.service;

import io.goorm.mybatis.board.model.Board;
import io.goorm.mybatis.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	public List<Board> getBoards(){

		return boardMapper.selectAll();
	}

	public Board getBoardById(Long seq){

		return boardMapper.selectById(seq);
	}

	public int createBoard(Board board){
		int result = 5;
		try{
			result = boardMapper.insert(board);
			log.debug(result + "");
		} catch (Exception e){
			log.error(e.toString());
		}
		return result;
	}

	public Board updateBoard(Board board){

		int result  = boardMapper.update(board);
		log.debug(result + "");
		return board;
	}

	public boolean deleteBoard(Long seq){

		try{
			int result = boardMapper.delete(seq);
			log.debug(result + "");
		} catch (Exception e){
			return false;
		}
		return true;
	}
}
