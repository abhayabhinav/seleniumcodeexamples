
public class Box {
	double width;
	double height;
	double length;
	
	Box(double w,double h,double l){
		width = w;
		height = h;
		length = l;
	}
	
	double volume() {
		return width*height*length;
		
	}
	
}
