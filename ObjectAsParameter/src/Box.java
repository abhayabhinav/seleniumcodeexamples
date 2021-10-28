
public class Box {
	double width;
	double height;
	double length;
	
	//volume of different sized box
	Box(double w, double h, double l){
		width = w;
		height = h;
		length = l;
	}
	
	//volume of cube
	Box(double len){
		width = height = length = len;
	}
	
	//volume when no dimension specified
	Box(){
		width = -1;
		height = -1;
		length = -1;
	}
	
	Box(Box ob){
		width = ob.width;
		height = ob.height;
		length = ob.length;
	}
	
	double volume() {
		return width*height*length;
	}
}


