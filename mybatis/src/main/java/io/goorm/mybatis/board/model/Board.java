package io.goorm.mybatis.board.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Board {

	private Long seq;
	private String title;

	private String contents;

	private String regUser;

	private LocalDateTime regDate;
}
