package MyPackage;
public class Triangle extends Figure {
	Triangle(double a, double b){
		super(a,b);
	}
	
	double area() {
		System.out.println("Area of Triangle is :");
		return dim1*dim2/2;
	}
}
