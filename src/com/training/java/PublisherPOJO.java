package com.training.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PUBLISHER")
public class PublisherPOJO 
{
	private int pubId;
	private String pubName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "pub_ID")
	public int getPubId() 
	{
		return pubId;
	}
	public void setPubId(int pubId) 
	{
		this.pubId = pubId;
	}
	
	@Column(name = "pub_name")
	public String getPubName() 
	{
		return pubName;
	}
	public void setPubName(String pubName) 
	{
		this.pubName = pubName;
	}
	public PublisherPOJO()
	{ 
		
	} 
	public PublisherPOJO(String name) 
	{ 
		this.pubName = name; 
		
	}
}
