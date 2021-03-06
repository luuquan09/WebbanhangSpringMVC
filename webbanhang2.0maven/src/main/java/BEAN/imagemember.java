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
@Table(name = "image_member")
public class imagemember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_image_mb")
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="id_member")
	private Mber id_image_mb;
	
	private String url;
	
	private String note;
	
	private boolean avt;

	public imagemember() {
		
	}

	public imagemember(Mber id_image_mb, String url, String note, boolean avt) {
		this.id_image_mb = id_image_mb;
		this.url = url;
		this.note = note;
		this.avt = avt;
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
