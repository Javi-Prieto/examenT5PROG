package ejercicio1;

import java.util.ArrayList;
import java.util.List;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Cancion> listado = new ArrayList<Cancion>();
		int id = 2, numR, op, opInt, idUser, opFre, numC;
		double dur;
		String artist, title;
		Cancion ca;
		MiMusica mus = new MiMusica(listado);
		mus.agregarCancion(new Cancion(0, 10, "Hola", "Juan", true, 0.2));		
		mus.agregarCancion(new Cancion(1, 15, "Cachau", "Juan", false, 5.2));
		mus.agregarCancion(new Cancion(2, 20, "Piano", "Pepe", true, 1));
		mus.agregarCancion(new Cancion(3, 22, "Ella", "Manolo", false, 3));
		mus.agregarCancion(new Cancion(4, 8, "Mia", "Manolo", true, 6));
		
		
		do {
			System.out.println("----------------------MENU----------------------");
			System.out.println("1. Canciones Gratis");
			System.out.println("2. Canción con mayor Duracion");
			System.out.println("3. Canciones de un artista");
			System.out.println("4. Canción más escuchada");
			System.out.println("5. Modificar una canción");
			System.out.println("6. Mostrar por Cantante");
			System.out.println("7. Mostrar por duracion");
			System.out.println("8. Generar aleatoriamente");
			System.out.println("9. Media duración");
			System.out.println("10. Imprimir todas");
			System.out.println("11. Agregar Cancion");
			System.out.println("0. Salir");
			System.out.println("------------------------------------------------");
			System.out.println("¿Qué desea hacer?");
			op = Leer.datoInt();
			switch(op) {
				case 1:
					mus.mostrarGratis();
					break;
				case 2:
					mus.mostrarMayorDuracion();
					break;
				case 3:
					System.out.println("Diga el artista");
					artist = Leer.dato();
					mus.mostrarMismoCantante(artist);
					break;
				case 4:
					mus.mostrarMasEscuchada();
					break;
				case 5:
					mus.mostrarTodas();
					System.out.println("Indique el id de la canción a modificar:");
					idUser = Leer.datoInt();
					System.out.println("------------");
					System.out.println("1. De Pago");
					System.out.println("2. Gratis");
					System.out.println("------------");
					System.out.println("¿Cómo desea establecer la canción?");
					opInt = Leer.datoInt();
					mus.cambiarGratis((opInt - 1), idUser);
					mus.mostrarUna(idUser);
					break;
				case 6:
					mus.mostrarPorCantante();
					break;
				case 7:
					mus.mostrarPorDuracion();
					break;
				case 8:
					System.out.println("Diga de cuantas canciones quiere la playlist");
					numC = Leer.datoInt();
					mus.mostrarPlaylist(numC);
					break;
				case 9:
					System.out.printf("La media de duración es %.2f", + mus.calcularMediaDuracion());
					break;
				case 10:
					mus.mostrarTodas();
					break;
				case 11:
					System.out.println("Diga el nombre del artista");
					artist = Leer.dato();
					System.out.println("Diga el título");
					title = Leer.dato();
					System.out.println("Diga el número de reproducciones");
					numR = Leer.datoInt();
					System.out.println("Diga la duracion");
					dur = Leer.datoDouble();
					System.out.println("Pulse 1 para que sea gratis o 2 para que sea de pago,"
							+ " si no pone uno de los números indicados, la canción por defecto será gratis");
					opFre = Leer.datoInt();
					
					ca = new Cancion(id, numR, title, artist, mus.comprobarGratis(opFre), dur);
					mus.agregarCancion(ca);
					break;
				case 0:
					System.out.println("Gracias por usar");
					break;
				default:
					System.out.println("Número inexistente");
			}
		}while(op != 0);
		
	}

}
