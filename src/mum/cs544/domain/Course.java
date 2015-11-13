package mum.cs544.domain;

public class Course {
	private long id;
	private String title;
	private String description;
	private Category category;
	private int price;
	private int rating;
	private String thumurl;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getThumurl() {
		return thumurl;
	}
	public void setThumurl(String thumurl) {
		this.thumurl = thumurl;
	}
	
	
	

}
