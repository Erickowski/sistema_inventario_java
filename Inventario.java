import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Cliente{
	int numCli;
	String nombre;
	Cliente(int numCli, String nombre){
		this.numCli = numCli;
		this.nombre = nombre;
	}
	public int getNumCli(){
		return (numCli);
	}
	public String getNombre(){
		return (nombre);
	}
}

class Producto{
	int cod;
	String nombre;
	double precio;
	int existencia;
	String medida;
	Producto(int cod,String nombre,double precio,int existencia,String medida){
		this.cod = cod;
		this.nombre = nombre;
		this.precio = precio;
		this.existencia = existencia;
		this.medida = medida;
	}
	public int getCod(){
		return (cod);
	}
	public String getNombre(){
		return(nombre);
	}
	public double getPrecio(){
		return(precio);
	}
	public int getExistencia(){
		return(existencia);
	}
	public String getMedida(){
		return(medida);
	}
	public void setExistencia(int existencia){
		this.existencia = existencia;
	}
}

class Inventario{
	public static void main(String args[])throws IOException{
		Cliente ArrayCli[] = new Cliente[5];
		Producto ArrayPro[] = new Producto[5];
		int opc,w=0, x=0,y,z=0,a=0,b[] = new int[10],c,cantidad=0,cuenta=0,inv,cve;
		String pause, nombre,medida;
		double precio=0.0,importe[] = new double[5],total=0.0,cobro = 0.0;
		ingresaDatos.cls();
		do{
			menu();
			opc = ingresaDatos.pideInt("\n\t\tSeleccione una opcion...  ");
			ingresaDatos.cls();
			switch(opc){
				case 1:
					do{
						if(w>=5){
							menu();
							System.out.println("\n\t  Ya has registrado demasiados productos");
							pause = ingresaDatos.pideString("\t  Presiona una tecla para continuar...");
							break;
						}
						System.out.println("\t  LO MISMO PERO MAS BARATO S.A. de C.V.");
						System.out.println("\t\tRegistrar productos\n");
						do{
							cuenta = ingresaDatos.pideInt("\t  Ingrese nuevo numero de producto: ");
							if(cuenta==0){
								System.out.println("\t\tDebe ingresar un numero valido...");
							}
						}while(cuenta==0);
						do{
							for(y=0;y<w;y++){
								if(cuenta == ArrayPro[y].getCod()){
									System.out.println("\t\tNumero de producto existente, ingrese otro...");
									cuenta = ingresaDatos.pideInt("\t  Ingrese numero de producto: ");
									y=36;
								}
							}
						}while(y!=w);
						nombre = ingresaDatos.pideString("\t  Ingresa nombre del producto: ");
						do{
							precio = ingresaDatos.pideDouble("\t  Ingrese precio del producto: ");
						}while(precio <= 0.0);
						do{
							cantidad = ingresaDatos.pideInt("\t  Ingresa cantidad en almacen: ");
							if(cantidad <= 0){
								System.out.println("\t\tDebe ingresar un numero valido...");
								pause = ingresaDatos.pideString("\t  Presione una tecla para continuar...");
							}
						}while(cantidad <= 0);
						do{
							medida = ingresaDatos.pideString("\t  Ingresa medida del producto K) Kilo P) Pieza L) Litro M) Metro: ");
							medida = medida.toUpperCase();
							if(medida.equals("K") == false && medida.equals("P") == false && medida.equals("L") == false && medida.equals("M") == false){
								System.out.println("\t\tDebe ingresar un caracter valido...");
							}
						}while(medida.equals("K") == false && medida.equals("P") == false && medida.equals("L") == false && medida.equals("M") == false);
						ArrayPro[w] = new Producto(cuenta,nombre,precio,cantidad,medida);
						w++;
						pause = ingresaDatos.pideBoolean("\t  Desea registrar otro producto? S-Si N-No -> ");
						ingresaDatos.cls();
					}while(pause.equals("S"));
					break;
				case 2:
					if(w==0){
						menu();
						System.out.println("\n\t  Aun no has registrado productos\n");
						pause = ingresaDatos.pideString("\t  Presione una tecla para continuar...");
					}
					else{
						do{
							System.out.println("\t  LO MISMO PERO MAS BARATO S.A. de C.V.");
							System.out.println("\t\tVer o actualizar almacen\n");						
							System.out.printf("%10s %15s %6s %6s %6s\n","Codigo","Descripcion","Precio","Medida","Existencia");
							for(y=0;y<w;y++){
								System.out.printf("%10d %15s %6.2f ",ArrayPro[y].getCod(),ArrayPro[y].getNombre(),ArrayPro[y].getPrecio());
								if(ArrayPro[y].getMedida().equals("K")) System.out.printf("%6s %6d\n","Kilo",ArrayPro[y].getExistencia());
								if(ArrayPro[y].getMedida().equals("P")) System.out.printf("%6s %6d\n","Pieza",ArrayPro[y].getExistencia());
								if(ArrayPro[y].getMedida().equals("L")) System.out.printf("%6s %6d\n","Litro",ArrayPro[y].getExistencia());
								if(ArrayPro[y].getMedida().equals("M")) System.out.printf("%6s %6d\n","Metro",ArrayPro[y].getExistencia());
							}
							pause = ingresaDatos.pideBoolean("\n\t  Desea actualizar almacen? S-Si N-No -> ");
							if(pause.equals("S")){
								do{
									y=0;
									cve = ingresaDatos.pideInt("\t\tIngresa codigo del producto: ");
									while(y<w && cve!=ArrayPro[y].getCod()){
										y++;
									}
									if(y>=w){
										pause = ingresaDatos.pideString("\t\tProducto inexistente...");
									}
								}while(y>=w);
								cve = ingresaDatos.pideInt("\t\tCantidad comprada: ");
								ArrayPro[y].setExistencia(suma(ArrayPro[y].getExistencia(),cve));
								pause = ingresaDatos.pideString("\t\tAlmacen actualizado...");
								pause = "S";
							}
							ingresaDatos.cls();
						}while(pause.equals("S"));
					}
					break;
				case 3:
					do{
						if(x>=5){
							menu();
							System.out.println("\n\t  Ya has registrado demasiados clientes ");
							pause = ingresaDatos.pideString("\t  Presiona una tecla para continuar...");
							break;
						}
						System.out.println("\t  LO MISMO PERO MAS BARATO S.A. de C.V.");
						System.out.println("\t\tRegistrar cliente\n");
						cuenta = ingresaDatos.pideInt("\t  Ingrese nuevo numero de cliente: ");
						do{
							for(y=0;y<x;y++){
								if(cuenta == ArrayCli[y].getNumCli()){
									System.out.println("\t\tNumero de cliente existente, ingrese otro...");
									cuenta = ingresaDatos.pideInt("\t  Ingrese numero de cuenta: ");
									y=36;
								}
							}
						}while(y!=x || cuenta <= 0);
						nombre = ingresaDatos.pideString("\t  Ingresa nombre del cliente: ");
						ArrayCli[x] = new Cliente(cuenta,nombre);
						x++;
						pause = ingresaDatos.pideBoolean("\t  Desea registrar otro cliente? S-Si N-No -> ");
						ingresaDatos.cls();
					}while(pause.equals("S"));
					break;
				case 4:
					if(x==0){
						menu();
						System.out.println("\n\t  Aun no has registrado clientes\n");
						pause = ingresaDatos.pideString("\t  Presiona una tecla para continuar...");
						break;
					}
					else{
						System.out.println("\t  LO MISMO PERO MAS BARATO S.A. de C.V.");
						System.out.printf("\t\t%20s\n\n","Clientes registrados");
						System.out.printf("\t %10s %15s\n","Numero de cliente","Nombre");
						for(y=0;y<x;y++){
							System.out.printf("\t %10d %21s\n",ArrayCli[y].getNumCli(),ArrayCli[y].getNombre());
							}
					}
					pause = ingresaDatos.pideString("\n\t  Presiona una tecla para continuar...");
					break;
				case 5:
					ingresaDatos.cls();
					c=0;
					total=0;
					if(x==0){
						menu();
						System.out.println("\n\t  Aun no has registrado clientes\n");
						pause = ingresaDatos.pideString("\t  Presiona una tecla para continuar...");
						break;
					}
					if(w==0){
						menu();
						System.out.println("\n\t  Aun no has registrado productos\n");
						pause = ingresaDatos.pideString("\t  Presione una tecla para continuar...");
						break;
					}
					do{
						System.out.println("\t  LO MISMO PERO MAS BARATO S.A. de C.V.");
						System.out.println("\t\tGenerar ticket de compra\n");
						do{
							cve = ingresaDatos.pideInt("\t\tIngresa numero de cliente: ");
							y=0;
							while(y<x && cve!=ArrayCli[y].getNumCli()){
								y++;
							}
							if(y>=x){
								pause = ingresaDatos.pideString("\t\tCliente inexistente...");
							}
						}while(y>=x);
						System.out.println("\t\tNo. Cliente: " + ArrayCli[y].getNumCli());
						System.out.println("\t\tNombre: " + ArrayCli[y].getNombre());
						do{
							do{
								cve = ingresaDatos.pideInt("\t  Ingresa numero de producto: ");
								z=0;
								while(z<w && cve!=ArrayPro[z].getCod()){
									z++;
								}
								if(z>=w) pause = ingresaDatos.pideString("\t\tProducto inexistente...");
							}while(z>=w);
							System.out.println("\t  Producto: " + ArrayPro[z].getNombre());
							System.out.println("\t  Precio: $" + ArrayPro[z].getPrecio());
							System.out.println("\t  Cantidad en almacen: " + ArrayPro[z].getExistencia());
							b[c] = z;
							if(ArrayPro[z].getExistencia() == 0){
								System.out.println("\t\tAlmacen vacio...");
							}
							else{
								do{
									b[9-c] = ingresaDatos.pideInt("\t\tCantidad a comprar: ");
									if(b[9-c] > ArrayPro[z].getExistencia()){
										System.out.println("\t\tInventario insuficiente...");
									}
								}while(b[9-c] > ArrayPro[z].getExistencia());
								importe[c] = multi(ArrayPro[z].getPrecio(),b[9-c]);
								ArrayPro[z].setExistencia(resta(ArrayPro[z].getExistencia(),b[9-c]));
								c++;
								if(c>=5){
									System.out.println("\t  Solo puede registrar 5 productos...");
									break;
								} 
							}
							pause = ingresaDatos.pideBoolean("\t  facturar otro producto? S-Si N-No  ");
						}while(pause.equals("S"));
						pause = ingresaDatos.pideString("\t\tGenerando ticket...");
						ingresaDatos.cls();
						Calendar fecha = new GregorianCalendar();
						int anio = fecha.get(Calendar.YEAR),mes = fecha.get(Calendar.MONTH)+1,dia = fecha.get(Calendar.DAY_OF_MONTH),hora = fecha.get(Calendar.HOUR_OF_DAY),minuto = fecha.get(Calendar.MINUTE),segundo = fecha.get(Calendar.SECOND);
						System.out.println("\t\t  LO MISMO PERO MAS BARATO S.A. de C.V.");
						System.out.println("\t\t\t Ticket de compra\n");
						System.out.println("\t\t\t" + hora + ":" + minuto + ":" + segundo + " del " + dia + "/" + mes + "/" + anio);
						System.out.println("\t\t\t Clave Cliente: " + ArrayCli[y].getNumCli() + "\n\t\t\t Nombre: " + ArrayCli[y].getNombre());
						System.out.printf("\n\t\t%15s %10s %10s %10s %10s","Producto","Medida","Precio","Cantidad" ,"Importe");
						for(y=0;y<c;y++){
							System.out.printf("\n\t\t%15s ",ArrayPro[ b[y] ].getNombre());
							if(ArrayPro[ b[y] ].getMedida().equals("K")) System.out.printf("%10s $%10.2f %10d $%10.2f","Kilo",ArrayPro[ b[y] ].getPrecio(),b[9-y],importe[y]);
							if(ArrayPro[ b[y] ].getMedida().equals("P")) System.out.printf("%10s $%10.2f %10d $%10.2f","Pieza",ArrayPro[ b[y] ].getPrecio(),b[9-y],importe[y]);
							if(ArrayPro[ b[y] ].getMedida().equals("L")) System.out.printf("%10s $%10.2f %10d $%10.2f","Litro",ArrayPro[ b[y] ].getPrecio(),b[9-y],importe[y]);
							if(ArrayPro[ b[y] ].getMedida().equals("M")) System.out.printf("%10s $%10.2f %10d $%10.2f","Metro",ArrayPro[ b[y] ].getPrecio(),b[9-y],importe[y]);
							total = sumaDouble(total,importe[y]);
						}
						System.out.printf("\n\t\t%25s $%10.2f\n","Total: ",total);
						do{
							cobro = ingresaDatos.pideDouble("\t\tIngrese monto a pagar: $");
							if(total > cobro){
								System.out.println("\t\tMonto insuficiente");
							}
						}while(cobro < total);
						System.out.printf("\n\t\t%25s $%10.2f","Cambio : ",restaDouble(cobro,total));
						System.out.println("\n\t\tTransaccion con exito...");
						pause = ingresaDatos.pideBoolean("\t  Desea generar otro ticket? S-Si N-No ");
					}while(pause.equals("S"));
					break;
				case 6:
					menu();
					System.out.println("\n\t\tCerrando sesion... ");
					pause = ingresaDatos.pideString("\t  Presiona una tecla para continuar...");
					break;
				default:
					menu();
					System.out.println("\n\t\tOpcion no valida");
					pause = ingresaDatos.pideString("\t  Presiona una tecla para continuar...");
					break;
			}
			ingresaDatos.cls();
		}while(opc!=6);
	}
	public static void menu(){
		System.out.println("\t  LO MISMO PERO MAS BARATO S.A. de C.V.");
		System.out.println("\t\tM E N U  P R I N C I P A L\n");
		System.out.println("\t\t1.- Registrar productos");
		System.out.println("\t\t2.- Ver o Actualizar almacen");
		System.out.println("\t\t3.- Registrar cliente");
		System.out.println("\t\t4.- Ver clientes registrados");
		System.out.println("\t\t5.- Generar ticket de compra");
		System.out.println("\t\t6.- Salir");
	}
	public static int suma(int a, int b){
		return(a+b);
	}
	public static int resta(int a, int b){
		return(a-b);
	}
	public static double multi(double a, int b){
		return(a*b);
	}
	public static double sumaDouble(double a, double b){
		return(a+b);
	}
	public static double restaDouble(double a, double b){
		return(a-b);
	}
}