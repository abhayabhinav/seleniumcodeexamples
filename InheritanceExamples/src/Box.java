
public class Box {
	double height;
	double width;
	double length;
	
	//Construct clone of an object
	Box(Box ob){            //Pass object to constructor
		height = ob.height;
		width = ob.width;
		length = ob.length;
	}
	
	//Constructor used when all dimensions are specified
	Box(double h, double w, double l){
		height = h;
		width = w;
		length = l;
	}
	
	//Constructor when no dimension specified
	Box(){
		height = -1;
		width = -1;
		length = -1;
	}
	
	//Construction when dimension is a cube
	Box(double len){
		height=width=length=len;
	}
	
	//compute and return volume
	double volume() {
		return height*width*length;
	}
}
