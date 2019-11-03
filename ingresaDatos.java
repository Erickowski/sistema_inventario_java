import java.io.*;
class ingresaDatos{
	private static BufferedReader leer= new BufferedReader(new InputStreamReader (System.in));
	public static String pideString(String mensaje)throws IOException{
		String cadena;
		System.out.print(mensaje);
		cadena = leer.readLine();
		return(cadena);
	}
	public static int pideInt(String mensaje)throws IOException{
		int numero=-1;
		while(numero<=0){
			System.out.print(mensaje);
			try{
				numero = Integer.parseInt(leer.readLine());
				if(numero<=0){
					System.out.println("\t\tDebe ingresar un numero valido...");
				}
			}
			catch(Exception e){
				System.out.println("\t\tDebe ingresar un numero valido...");
				numero = -1;
			}
		}
		return(numero);
	}
	public static double pideDouble(String mensaje)throws IOException{
		double numero=-1.0;
		while(numero<0.0){
			System.out.print(mensaje);
			try{
				numero = Double.parseDouble(leer.readLine());
				if(numero<=0.0){
					System.out.println("\t\tDebe ingresar un numero valido...");
				}
			}
			catch(Exception e){
				System.out.println("\t\tDebe ingresar un numero valido...");
				numero = -1.0;
			}
		}
		return(numero);
	}
	public static String pideBoolean(String mensaje)throws IOException{
		String opcion="ERICK";
		while(opcion.equals("S")==false && opcion.equals("N")== false){
			System.out.print(mensaje);
			opcion = leer.readLine();
			opcion = opcion.toUpperCase();
			if(opcion.equals("S")==false && opcion.equals("N")== false){
				System.out.println("\t\tDebe ingresar una opcion valida...");
				opcion = "ERICK";
			}
		}
		return(opcion);
	}
	public static void cls(){
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {}
	}
}