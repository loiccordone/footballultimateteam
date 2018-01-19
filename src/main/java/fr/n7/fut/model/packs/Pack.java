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
	private PackType packType;

	@Enumerated(EnumType.STRING)
	private PackFormat packFormat;

	private int price;

	public Pack() {
	}

	public Pack(PackType pt, PackFormat pf) {
		this.packType = pt;
		this.packFormat = pf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public PackType getPackType() {
		return packType;
	}
	public void setPackType(PackType packType) {
		this.packType = packType;
	}
	public PackFormat getPackFormat() {
		return packFormat;
	}
	public void setPackFormat(PackFormat packFormat) {
		this.packFormat = packFormat;
	}
	
	
}
