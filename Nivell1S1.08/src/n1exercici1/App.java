package n1exercici1;

import java.io.*;
import java.util.*;

public class App{
	
	public static void main(String[] args) {
		
	//Fase 1 Part 1: Tenint una llista de cadenes de noms propis,  
	//escriu un mètode que retorn e una llista de totes les cadenes que  comencen amb la lletra 'a' (mayuscula ) 
	//i  tenen exactament 3  lletres. Imprimeix el resultat. 
		
	
		List<String> nombres = new ArrayList<String>(Arrays.asList("Ana", "Lucian", "Veronica", "Clara", "Abe", "Nolan"));
		
		List<String> nombresEmpiezanAConTresLetras = new ArrayList<String>(Arrays.asList("Ana", "Lucian", "Veronica", "Clara", "Abe", "Nolan"));
		
		nombresEmpiezanAConTresLetras.removeIf(nom -> (nom.charAt(0)!='A' || nom.length()!=3));
		
		System.out.println("LLista original: " + nombres.toString());
		
		System.out.println("LLista modificada: " + nombresEmpiezanAConTresLetras.toString());
		
	//Part 2: Escriu un mètode que retorne una cadena separada per comes basada en una llista d’Integers.  
	
		List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1, 6, 12, 3, 0));
		
		StringFunction concat2 = (s, d) -> s + d +  ",";
		
		String numerosEO = eoEmparella(numeros, concat2);
		
		System.out.println("LLista original: " + numeros.toString());
		
		System.out.println("LLista modificada: " + numerosEO.toString());
		
	//Part 3: Tenint una llista de Strings, escriu un mètode  
	//que retorne una llista de totes les  cadenes  que continguen la lletra ‘o’ i  imprimeix el resultat .
		
		BooleanFunction2 onlyLetra = (s, d) -> s.contains(d);
		
		List<String> nombresConO = filterLetra(nombres, onlyLetra, "o");
		
		System.out.println("LLista modificada: " + nombresConO.toString());
		
	//Part 4:  incloga els elements amb  més de 5 lletres.
	
		BooleanFunction3 onlyCincOMes = (s, d) -> s.length()>=d;
		
		List<String> nombresCincOMes = filterLargo(nombres, onlyCincOMes, 5);
		
		System.out.println("LLista modificada: " + nombresCincOMes.toString());
		
	//Part 5: Crea una llista amb  els nombs dels mesos de  l’any. Imprimeix tots els  elements de la llista amb  una lambda. 
		
		List<String> meses = new ArrayList<String>(Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
				"Septiembre", "Octubre", "Noviembre", "Diciembre"));
		
		meses.forEach(p -> System.out.print(p + ", "));
		
	//Part 6: 
		meses.stream().forEach(System.out::println);
	}
	
//METODES
	
	public static String eoEmparella(List<Integer> input, StringFunction ePar) {
		
		String inputEmparellat = "";
		
		for (int i=0; i<input.size(); i++) {
		
			if (esParell(input.get(i))) {
			
				inputEmparellat = ePar.run(inputEmparellat,  "e" + input.get(i) );
			
			} else if (!esParell(input.get(i))) {
			
				inputEmparellat = ePar.run(inputEmparellat, "o" + input.get(i) );
			
			}
		}
		
		inputEmparellat = removeLastChars(inputEmparellat,1);//treiem la ultima coma
		
		
		return inputEmparellat;
	}
	
	public static boolean esParell(int integer) {
		return integer % 2 == 0;
	}
	
	public static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }
	
	public static ArrayList<String> filterLetra(List<String> input, BooleanFunction2 onlyO, String letra) {
		
		ArrayList<String> inputFiltrado = new ArrayList<String>();
		
		for (int i=0; i<input.size(); i++) {
			
			if (onlyO.run2(input.get(i),letra)) {
				
				inputFiltrado.add(input.get(i));
				
			}
			
		}
		
		return inputFiltrado;
	}
	
	public static ArrayList<String> filterLargo(List<String> input, BooleanFunction3 onlyO, Integer largo) {
		
		ArrayList<String> inputFiltrado = new ArrayList<String>();
		
		for (int i=0; i<input.size(); i++) {
			
			if (onlyO.run2(input.get(i),largo)) {
				
				inputFiltrado.add(input.get(i));
				
			}
			
		}
		
		return inputFiltrado;
	}
	
	public void print(String input) {
		System.out.print(input);
	}
}
