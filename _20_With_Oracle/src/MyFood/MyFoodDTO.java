package MyFood;

public class MyFoodDTO {
	private String foodId = null; 
	private String foodName = null;
	private Integer foodNum = 0;
	private String indate=null;
	
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Integer getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(Integer foodNum) {
		this.foodNum = foodNum;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	public void prt() {
		System.out.println("음식ID["+foodId+"] 음식명["+foodName+"] 음식수["+foodNum+"]"+" 입력시간["+indate+"]");
	}
}
