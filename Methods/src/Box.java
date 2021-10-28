
public class Box {
	double width;
	double height;
	double breadth;
	
	double volume() {
		return (width*height*breadth);
	}
	void SetDim(double w,double h, double b) {
		width = w;
		height = h;
		breadth = b;
	}
}
