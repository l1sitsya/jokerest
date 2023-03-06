package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Comment")
@Table(name = "commentaries")
@NoArgsConstructor
@Data

public class comment {

	@JsonProperty(value = "comment_id")
	@Id
	@SequenceGenerator(
			name = "comment_id",
			sequenceName = "comment_id",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "comment_id"		
	)
	private long commentID;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Anecdot anecdot;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	private user user;
	
	@Column(name = "comment_content")
	private String comment;
	
	@Column(name = "likes")
	private int likes;
	
	@Column(name = "dislikes")
	private int dislikes;
	
}
