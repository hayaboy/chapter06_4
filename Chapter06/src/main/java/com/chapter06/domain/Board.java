package com.chapter06.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Board {

	@Id
	@GeneratedValue
	private Long seq;

	
	private String title;

	@Column(updatable = false)  //하이버네이트가 UPDATE SQL을 제너레이션할 때 writer, createDate,cnt 칼럼 제외
	private String writer;

	private String content;

	
	@Column(insertable = false, updatable = false, columnDefinition = "date default CURRENT_TIMESTAMP")//insertable = false 기본값을 설정했기 때문에 INSERT SQL 제외, h2에서는 sysdate가 안먹힘
	private Date createDate;

	@Column(insertable = false,updatable = false, columnDefinition = "number default 0")
	private Long cnt;
}
