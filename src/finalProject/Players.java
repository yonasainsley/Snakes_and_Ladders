package finalProject;

abstract class Players {
	int Point1=0;
	int Point2=0;
	abstract void addPoint();
	public int getPoint1() {
		return Point1;
	}
	public int getPoint2() {
		return Point2;
	}
	
}

class playerOne extends Players{

	void addPoint(){
		Point1++;
	}
	
}
class playerTwo extends Players{

	void addPoint(){
		Point2++;
	}
	
}