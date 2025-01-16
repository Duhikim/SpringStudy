package io.goorm.mybatis.api.board.controller;

import io.goorm.mybatis.api.board.service.BoardService;
import io.goorm.mybatis.board.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardRestController {

	private BoardService boardService;

	public String index() {

		return "api index";
	}

		// List
	@GetMapping("/boards")
	public List<Board> list() {
		List<Board> list = boardService.getBoards();

		log.debug("list size : " + list.size());
		log.debug("test ");
		return list;

	}


}
