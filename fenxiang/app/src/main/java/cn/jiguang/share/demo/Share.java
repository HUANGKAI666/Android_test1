package cn.jiguang.share.demo;

public class Share {

	private String name;

	private int imageId;

	public Share(String name, int imageId) {
		this.name = name;
		this.imageId = imageId;
	}

	public Share() {
	
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public int getImageId() {
		return imageId;
	}

}
