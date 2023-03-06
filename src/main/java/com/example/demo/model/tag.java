package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Tag")
@Table(name = "tags")
@NoArgsConstructor
@Data

public class tag {
	@Id
    @SequenceGenerator(
            name = "tag_id",
            sequenceName = "tag_id",
            allocationSize = 1
    )
    @GeneratedValue(
    		strategy = GenerationType.SEQUENCE,
    		generator = "tag_id"
    )
	@Column(name = "tag_id")
	private int tagID;
    
	@Column(name = "tag_name")
	private String tagName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private Set<Anecdot> Anecdotes;
	
}
