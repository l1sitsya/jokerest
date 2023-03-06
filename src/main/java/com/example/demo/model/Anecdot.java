package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Anecdot")
@Table(name = "anecdot")
@NoArgsConstructor
@Data

public class Anecdot {
	@JsonProperty(value = "id")
    @javax.persistence.Id
    @SequenceGenerator(
            name = "id",
            sequenceName = "id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id"
    )
	
    @Column(name = "id")
    private long anecId;
	
	@JsonProperty(value = "load_date")
	@Column(name = "load_date", nullable = false)
	private LocalDate loaddate;
	
	@Column(name = "rating")
	private double rating;
	
	@Column(name = "content_path")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private user owner_UID;
	
	@ManyToMany(mappedBy = "Anecdotes")
	private Set<tag> tags;
	
	@JsonBackReference
	@OneToMany(mappedBy = "anecdot", cascade = CascadeType.ALL, orphanRemoval = true)
	private final List<comment> comments = new ArrayList<>();
	
	
}
