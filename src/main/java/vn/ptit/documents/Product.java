package vn.ptit.documents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	@Id
	private String id;
	private String name;
	private int saleoff;
	private double price;
	private Date dateCreate;
	private String content;
	private int amountStock;
	private String brand;
	private String material;
	private String slug;
	private boolean status;
	private String video;
	private String categoryId;
	
	private List<ImgProduct> listImg = new ArrayList<>();
	
	public void addImgProduct(ImgProduct imgProduct) {
		listImg.add(imgProduct);
	}

	public Product() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSaleoff() {
		return saleoff;
	}

	public void setSaleoff(int saleoff) {
		this.saleoff = saleoff;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public int getAmountStock() {
		return amountStock;
	}

	public void setAmountStock(int amountStock) {
		this.amountStock = amountStock;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<ImgProduct> getListImg() {
		return listImg;
	}

	public void setListImg(List<ImgProduct> listImg) {
		this.listImg = listImg;
	}

}
