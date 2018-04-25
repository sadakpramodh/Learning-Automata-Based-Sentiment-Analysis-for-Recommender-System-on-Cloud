package com;
import java.util.ArrayList;
public class Classify{
	static ArrayList<String> positive;
	static ArrayList<String> negative;
	static ArrayList<Movies> movie;
	static ArrayList<MovieReviews> movie_review;
	static ArrayList<Restaurants> restaurant;
	static ArrayList<RestaurantReviews> restaurant_review;
public static void classify(String option){
	positive = DBCon.positive;
	negative = DBCon.negative;
	movie = DBCon.movie;
	movie_review = DBCon.movie_review;
	restaurant = DBCon.restaurant;
	restaurant_review = DBCon.restaurant_review;
	if(option.equals("MOVIES")){
		for(MovieReviews mr : movie_review){
			String summary[] = mr.getSummary().split("\\s+");
			int pos = 0;
			int neg = 0;
			for(int i=0;i<summary.length;i++){
				String str = summary[i].trim();
				if(str.length() > 0){
					if(positive.contains(str)){
						pos = pos + 1;
					}
					if(negative.contains(str)){
						neg = neg + 1;
					}
				}
			}
			if(pos > neg)
				mr.setResult("Positive");
			if(neg > pos)
				mr.setResult("Negative");
		}
	}
	if(option.equals("RESTAURANT")){
		for(RestaurantReviews mr : restaurant_review){
			String summary[] = mr.getSummary().split("\\s+");
			int pos = 0;
			int neg = 0;
			for(int i=0;i<summary.length;i++){
				String str = summary[i].trim();
				if(str.length() > 0){
					if(positive.contains(str)){
						pos = pos + 1;
					}
					if(negative.contains(str)){
						neg = neg + 1;
					}
				}
			}
			if(pos > neg)
				mr.setResult("Positive");
			if(neg > pos)
				mr.setResult("Negative");
		}
	}
}
public static String getLoc(String id){
	String arr = "";
	for(Restaurants res : restaurant){
		if(res.getID().equals(id)){
			arr = res.getLat()+","+res.getLon();
			break;
		}
	}
	return arr;
}
public static String getName(String id){
	String arr = "";
	for(Restaurants res : restaurant){
		if(res.getID().equals(id)){
			arr = res.getName()+","+res.getAddress();
			break;
		}
	}
	return arr;
}
public static void classify(String lat,String lon,String name){
	positive = DBCon.positive;
	negative = DBCon.negative;
	movie = DBCon.movie;
	movie_review = DBCon.movie_review;
	restaurant = DBCon.restaurant;
	restaurant_review = DBCon.restaurant_review;
	double l3 = Double.parseDouble(lat);
	double l4 = Double.parseDouble(lon);
	for(RestaurantReviews mr : restaurant_review){
		String pname = mr.getName().toLowerCase();
		if(name.equals(pname)){
			String str = getLoc(mr.getID());
			if(str.length() > 0){
				String arr[] = str.split(",");
				double l1 = Double.parseDouble(arr[0]);
				double l2 = Double.parseDouble(arr[1]);
				double dis = distance(l1,l2,l3,l4,'M');
				String summary[] = mr.getSummary().split("\\s+");
				int pos = 0;
				int neg = 0;
				for(int i=0;i<summary.length;i++){
					String str1 = summary[i].trim();
					if(str1.length() > 0){
						if(positive.contains(str1)){
							pos = pos + 1;
						}
						if(negative.contains(str1)){
							neg = neg + 1;
						}
					}
				}
				mr.setDistance(dis);
				if(pos > neg)
					mr.setResult("Positive");
				if(neg > pos)
					mr.setResult("Negative");
			}
		}
	}
	java.util.Collections.sort(restaurant_review,new RestaurantReviews());
}

private static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
	double theta = lon1 - lon2;
	double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	dist = Math.acos(dist);
	dist = rad2deg(dist);
	dist = dist * 60 * 1.1515;
	if (unit == 'K') {
		dist = dist * 1.609344;
	} else if (unit == 'N') {
		dist = dist * 0.8684;
	}
	return (dist);
}
private static double deg2rad(double deg) {
	return (deg * Math.PI / 180.0);
}
private static double rad2deg(double rad) {
	return (rad * 180.0 / Math.PI);
}		
}