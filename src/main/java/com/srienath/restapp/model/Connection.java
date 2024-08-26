package com.srienath.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "connection")

public class Connection {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private String description;
    
    @Lob
    @Column(name="cropsimage",length=1000)
    private byte[] cropsImage;
    
    private int ratings;
    
    private String reviews;
    
    private String location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getCropsImage() {
		return cropsImage;
	}

	public void setCropsImage(byte[] cropsImage) {
		this.cropsImage = cropsImage;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Connection(int id, String name, String description, byte[] cropsImage, int ratings, String reviews,
			String location) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cropsImage = cropsImage;
		this.ratings = ratings;
		this.reviews = reviews;
		this.location = location;
	}

	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}

}
