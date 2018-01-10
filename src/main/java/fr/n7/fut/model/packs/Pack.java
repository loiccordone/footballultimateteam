package fr.n7.fut.model.packs;

import javax.persistence.*;

@Entity
@Table(name="packs")
public class Pack {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pack")
	private int id;

	@Enumerated(EnumType.STRING)
	private PackType type;

	@Enumerated(EnumType.STRING)
	private PackFormat format;

	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public PackType getType() {
		return type;
	}
	public void setType(PackType type) {
		this.type = type;
	}
	public PackFormat getFormat() {
		return format;
	}
	public void setFormat(PackFormat format) {
		this.format = format;
	}
	
	
}
