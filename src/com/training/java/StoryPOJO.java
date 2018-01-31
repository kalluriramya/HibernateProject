package com.training.java;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Story")
public class StoryPOJO {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "STORY_ID")
	private int storyId;

	@Column(name = "STORY_NAME")
	private String storyName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STORY_WRITER")
	private WriterPOJO writer;

	public WriterPOJO getWriter() {
		return writer;
	}

	public void setWriter(WriterPOJO writer) {
		this.writer = writer;
	}

	public StoryPOJO() {

	}

	public StoryPOJO(String name) {
		this.storyName = name;
	}

	public StoryPOJO(String name, WriterPOJO writer) {
		this.storyName = name;
		this.writer = writer;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

}
