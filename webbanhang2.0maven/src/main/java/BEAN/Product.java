package BEAN;



import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import DAO.ImageproductDAO;
import DAO.ProductDAO;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private int id;
	private String name;
	private float price;
	private String detail;
	private int quality;
	private float discount;
	
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date dateupdate;
	
	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern = "MM/dd/yyyy ")
	private Date datecreate;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "category_pd",
			joinColumns = @JoinColumn(name="id_product"),
			inverseJoinColumns = @JoinColumn(name="id_category_pd"))
	private Set<Category_product> categoryproduct = new HashSet<>();



	
	
	public Set<Category_product> product() {
		return categoryproduct;
	}

	public void setCategoryproduct(Set<Category_product> categoryproduct) {
		this.categoryproduct = categoryproduct;
	}

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Product_review> product_review = new HashSet<>();
	
	@OneToMany(mappedBy ="img_product",cascade = CascadeType.ALL)
	private Set<imageproduct> imgproduct = new HashSet<>();
	
	@OneToMany(mappedBy = "productitem", cascade = CascadeType.ALL)
	private Set<Cartitems> product_item = new HashSet<>();
	
	
	@OneToMany(mappedBy ="product_size",cascade = CascadeType.ALL)
	private Set<Size_category_product> size = new HashSet<>();
	
	@OneToMany(mappedBy ="orderitemproduct",cascade = CascadeType.ALL)
	private Set<Order_item> order_items = new HashSet<>();
	
	public Product() {

	}
	
	public Product(String name, float price, String detail, int quality, float discount, Date dateupdate,
			Date datecreate) {
		
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.quality = quality;
		this.discount = discount;
		this.dateupdate = dateupdate;
		this.datecreate = datecreate;
	
	}


	public List<Size_category_product> getListsize(){
		ProductDAO productDAO = new ProductDAO();
		return productDAO.findsizebyidpd(this);
	}


	public Set<Category_product> getCategoryproduct() {
		return categoryproduct;
	}

	public String getimgavt() {
		ImageproductDAO image = new ImageproductDAO();
		return image.getavtimage(this).getUrl();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<imageproduct> getImgproduct() {
		return imgproduct;
	}

	public void setImgproduct(Set<imageproduct> imgproduct) {
		this.imgproduct = imgproduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Date getDateupdate() {
		return dateupdate;
	}

	public void setDateupdate(Date dateupdate) {
		this.dateupdate = dateupdate;
	}

	public Date getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}

	public void addCategory(Category_product category_product) {
		this.categoryproduct.add(category_product);
	}

	public void addReview(Product_review product_review) {
		this.product_review.add(product_review);
	}
	public void addImage(imageproduct img) {
		this.imgproduct.add(img);
	}
	public void addSize(Size_category_product size) {
		this.size.add(size);
		}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + ", quality="
				+ quality + ", discount=" + discount + ", dateupdate=" + dateupdate + ", datecreate=" + datecreate
				+ ", categoryproduct=" + categoryproduct + ", product_review=" + product_review + ", imgproduct="
				+ imgproduct + ", product_item=" + product_item + "]";
	}

	
}
