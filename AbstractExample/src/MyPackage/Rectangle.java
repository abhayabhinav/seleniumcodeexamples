package MyPackage;
public class Rectangle extends Figure {
	Rectangle(double a, double b){
		super(a,b);
	}
	double area() {
		// TODO Auto-generated method stub
		System.out.println("Area of the Rectnagle is :");
		return dim1*dim2;
	}
}
