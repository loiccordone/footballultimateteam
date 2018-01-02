package fr.n7.fut.model.packs;

public class Pack {
	private int price;
	private PackType type;
	private PackFormat format;
	
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
