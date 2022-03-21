package n1exercici1Fase3;

public class App {

	public static void main(String[] args) {
		
		String frase = "Hola caracola!";
		
		
		
		Reverser reverser = (input) -> {   // lambda expression
	         String output = "";
	         
	         for(int i = input.length()-1; i >= 0; i--)
	        	 
	        	 output += input.charAt(i);
	         
	         return output;
	         
	      };
		
	    System.out.println(frase + " del reves es: " + reverser.reverse(frase));

	}

}
