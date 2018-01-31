package com.training.java;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Writer")
public class WriterPOJO 
{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "WRITER_ID")
	private int writerId;

	@Column(name = "WRITER_NAME") 
	private String writerName;
	
	@OneToMany(targetEntity = StoryPOJO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "STORY_WRITER", referencedColumnName = "WRITER_ID")
	private Set<StoryPOJO> stories;
	
	public Set<StoryPOJO> getStories() {
		return stories;
	}

	public void setStories(Set<StoryPOJO> stories) {
		this.stories = stories;
	}

	public WriterPOJO() 
	{
		
	}

	public WriterPOJO(String name) 
	{ 
		this.writerName = name; 
	}
	public int getWriterId() 
	{
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	
}
