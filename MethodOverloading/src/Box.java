
public class Box {
	double width;
	double height;
	double length;
	
	Box(double w, double h, double l) {
		width = w;
		height = h;
		length = l;
	}
	
	Box(){
		width = -1;
		height = -1;
		length = -1;
	}
	
	Box(double len){
		width = height = length = len;
	}
	
	double volume() {
		return width*height*length;
	}
}
