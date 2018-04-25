package com;
import java.util.Comparator;
public class RestaurantReviews implements Comparator<RestaurantReviews>{
	String id,product,name,summary,text,result;
	double distance;
public void setID(String id){
	this.id = id;
}
public String getID(){
	return id;
}
public void setProduct(String product){
	this.product = product;
}
public String getProduct(){
	return product;
}
public void setName(String name){
	this.name = name;
}
public String getName(){
	return name;
}
public void setSummary(String summary){
	this.summary = summary;
}
public String getSummary(){
	return summary;
}
public void setText(String text){
	this.text = text;
}
public String getText(){
	return text;
}
public void setResult(String result){
	this.result = result;
}
public String getResult(){
	return result;
}
public void setDistance(double distance){
	this.distance = distance;
}
public double getDistance(){
	return distance;
}
public int compare(RestaurantReviews p1,RestaurantReviews p2){
	double s1 = p1.getDistance();
    double s2 = p2.getDistance();
	if (s1 == s2)
		return 0;
    else if (s1 > s2)
    	return 1;
    else
		return -1;
}
}