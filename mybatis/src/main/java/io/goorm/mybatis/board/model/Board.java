package io.goorm.mybatis.board.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Board {

	private Long seq;
	private String title;

	private String contents;

	@JsonProperty("reguser")
	private String regUser;

	@JsonProperty("regdate")
	private LocalDateTime regDate;

}
