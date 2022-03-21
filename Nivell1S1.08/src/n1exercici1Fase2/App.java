package n1exercici1Fase2;

public class App {

	public static void main(String[] args) {
		
		double pi = 3.1415;
		
		PiValuer piValue = () -> pi;
		
		System.out.println(piValue.getPiValue());

	}

}
