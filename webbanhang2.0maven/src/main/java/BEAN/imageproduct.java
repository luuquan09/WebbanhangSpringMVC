package BEAN;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="image_product")
public class imageproduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_image")
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="id_product")
	private Product img_product;
	
	private String url;
	
	private String note;
	
	private boolean avt;

	
	public imageproduct() {
		
	}

	public imageproduct(Product image_product, String url, String note, boolean avt) {
		this.img_product=image_product;
		this.url = url;
		this.note = note;
		this.avt = avt;
	}



	public Product getImg_product() {
		return img_product;
	}

	public void setImg_product(Product img_product) {
		this.img_product = img_product;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isAvt() {
		return avt;
	}

	public void setAvt(boolean avt) {
		this.avt = avt;
	}
	
	
	
	
}
