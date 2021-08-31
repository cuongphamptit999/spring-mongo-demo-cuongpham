package vn.ptit.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class ImgProduct {	
	private String name;
	
	public ImgProduct() {
		
	}

	public ImgProduct(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
