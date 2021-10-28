
public class Rectangle extends Figure {
	Rectangle(double a, double b){
		super(a, b);
	}
	
	double area() {
		System.out.println("Area of Rectangle");
		return dim1*dim2;
	}
}
