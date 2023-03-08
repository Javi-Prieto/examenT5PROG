package ejercicio1;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MiMusica {
	//Fields
	private List <Cancion> lista;
	//Constructor

	public MiMusica(List<Cancion> lista) {
		super();
		this.lista = lista;
	}
	//Getter and setter

	public List<Cancion> getLista() {
		return lista;
	}

	public void setLista(List<Cancion> lista) {
		this.lista = lista;
	}
	//toString

	@Override
	public String toString() {
		return "MiMusica [lista=" + lista + "]";
	}
	//Methods
	public boolean agregarCancion(Cancion ca) {
		if(ca != null) {
			lista.add(ca);
			return true;
		}else {
			return false;
		}
	}
	public void mostrarCancionAgregada(Cancion ca) {
		if(agregarCancion(ca)) {
			System.out.println("Canción agregada correctamente");
		}else {
			System.out.println("Canción inexistente");
		}
	}
	public Cancion[] buscarGratis() {
		Iterator<Cancion> it = lista.iterator();
		Cancion[] listaGratis = new Cancion[lista.size()];
		Cancion ca;
		int i = 0;
		while(it.hasNext()) {
			ca = it.next();
			if(ca.isGratis()) {
				listaGratis[i] = ca;
				i++;
			}
		}
		return listaGratis;
	}
	public void mostrarGratis() {
		System.out.println("----------CANCIONES-------------");
		for(int i = 0; i < buscarGratis().length && buscarGratis()[i] != null; i++) {
			
			System.out.println("Título: " + buscarGratis()[i].getTitulo());
			System.out.println("Cantante: " + buscarGratis()[i].getCantante());
			System.out.println("Reproducciones: " + buscarGratis()[i].getNumRepro());
			System.out.printf("Duración: %.2f\n", buscarGratis()[i].getDuracion());
			System.out.println("-----------------------");
		}
	}
	public Cancion buscarMayorDuracion() {
		int i = 0;
		Cancion mayor = lista.get(i);
		for(Cancion ca : lista) {
			if(ca.getDuracion() > mayor.getDuracion()) {
				mayor = ca;
			}
		}
		return mayor;
	}
	public void mostrarMayorDuracion() {
		System.out.println("-----------------------");
		System.out.println("Título: " + buscarMayorDuracion().getTitulo());
		System.out.println("Cantante: " + buscarMayorDuracion().getCantante());
		System.out.println("Reproducciones: " + buscarMayorDuracion().getNumRepro());
		System.out.printf("Duración: %.2f\n", buscarMayorDuracion().getDuracion());
		System.out.println("-----------------------");
	}
	public Cancion[] findByCantante(String nom) {
		Cancion[] listaCantante = new Cancion[lista.size()];
		int i = 0;
		for(Cancion ca : lista) {
			if(ca.getCantante().equalsIgnoreCase(nom)) {
				listaCantante[i] = ca;
				i++;
			}
		}
		return listaCantante;
	}
	public void mostrarMismoCantante(String nom) {
		System.out.println("----------CANCIONES-------------");
		for(int i = 0; i < findByCantante(nom).length && findByCantante(nom)[i] != null; i++) {
			
			System.out.println("Título: " + findByCantante(nom)[i].getTitulo());
			System.out.println("Cantante: " + findByCantante(nom)[i].getCantante());
			System.out.println("Reproducciones: " + findByCantante(nom)[i].getNumRepro());
			System.out.printf("Duración: %.2f\n", findByCantante(nom)[i].getDuracion());
			System.out.println("-----------------------");
		}
	}
	
	public Cancion buscarCancionMasEscuchada() {
		Iterator <Cancion> it = lista.iterator();
		Cancion ca, mayor = lista.get(0);
		
		while(it.hasNext()) {
			ca = it.next();
			if(ca.getNumRepro() > mayor.getNumRepro()) {
				mayor = ca;
			}
		}
		return mayor;
	}
	public void mostrarMasEscuchada() {
		System.out.println("-----------------------");
		System.out.println("Título: " +buscarCancionMasEscuchada().getTitulo());
		System.out.println("Cantante: " + buscarCancionMasEscuchada().getCantante());
		System.out.println("Reproducciones: " + buscarCancionMasEscuchada().getNumRepro());
		System.out.printf("Duración: %.2f\n", buscarCancionMasEscuchada().getDuracion());
		System.out.println("-----------------------");
	}
	public boolean comprobarGratis(int op) {
		if(op == 0) {
			return true;
		}else {
			if(op == 1) {
			return false;
			}else {
				return true;
			}
		}
	}
	public int findById(int id) {
		boolean encontrado = false;
		int i = 0;
		while(i < lista.size() && !encontrado) {
			if(lista.get(i).getId() == id) {
				encontrado = true;
			}else {
				i++;
			}
		}
		if(lista.size() < i) {
			return -1;
		}else {
			return i;
		}
		
	}
	public void cambiarGratis(int op, int id) {
		if(findById(id)>= 0) {
			if(op == 0) {
				lista.get(findById(id)).setGratis(false);
			}else {
				if( op == 1) {
					lista.get(findById(id)).setGratis(true);
				}else {
					System.out.println("Número incorrecto");
				}
			}
		}else {
			System.out.println("No encontrado");
		}
	}
	
	public void mostrarUna(int id) {
		System.out.println("-----------------------");
		System.out.println("Título: " +lista.get(findById(id)).getTitulo());
		System.out.println("Cantante: " + lista.get(findById(id)).getCantante());
		System.out.println("Reproducciones: " + lista.get(findById(id)).getNumRepro());
		System.out.printf("Duración: %.2f\n", lista.get(findById(id)).getDuracion());
		System.out.println("Gratis: " + lista.get(findById(id)).isGratis());
		System.out.println("-----------------------");
	}
	
	public void mostrarPorCantante() {
		Collections.sort(lista);
		for(Cancion ca : lista) {
			System.out.println("-----------------------");
			System.out.println("Título: " + ca.getTitulo());
			System.out.println("Cantante: " + ca.getCantante());
			System.out.println("Reproducciones: " + ca.getNumRepro());
			System.out.printf("Duración: %.2f\n", ca.getDuracion());
			System.out.println("Gratis: " + ca.isGratis());
			System.out.println("-----------------------");
		}
	}
	
	public void mostrarPorDuracion() {
		Collections.sort(lista, new CompararPorDuracion());
		System.out.println("----------CANCIONES-------------");
		for(Cancion ca : lista) {
			System.out.println("Título: " + ca.getTitulo());
			System.out.println("Cantante: " + ca.getCantante());
			System.out.println("Reproducciones: " + ca.getNumRepro());
			System.out.printf("Duración: %.2f\n", ca.getDuracion());
			System.out.println("Gratis: " + ca.isGratis());
			System.out.println("-----------------------");
		}
	}
	
	public double calcularMediaDuracion() {
		double durMedia = 0;
		for(Cancion ca : lista) {
			durMedia += ca.getDuracion();
		}
		durMedia /= (double)lista.size();
		return durMedia;
	}
	
	public void mostrarTodas() {
		Iterator<Cancion> it = lista.iterator();
		Cancion ca;
		System.out.println("----------CANCIONES-------------");
		while(it.hasNext()) {
			ca = it.next();
			System.out.println("Id: " + ca.getId());
			System.out.println("Título: " + ca.getTitulo());
			System.out.println("Cantante: " + ca.getCantante());
			System.out.println("Reproducciones: " + ca.getNumRepro());
			System.out.printf("Duración: %.2f\n", ca.getDuracion());
			System.out.println("Gratis: " + ca.isGratis());
			System.out.println("-----------------------");
		}
	}
	public Cancion[] generarPlaylist(int numC) {
		Cancion[] playlist = new Cancion[numC];
		int desde = 0, hasta = lista.size()-1, rnd;
		Random rn = new Random(System.nanoTime());
		for(int i = 0; i < playlist.length; i++) {
			rnd = rn.nextInt(hasta - desde + 1)+desde;
			playlist[i] = lista.get(rnd);
		}
		/*for(int i = 0 ; i < playlist.length; i++){			
			for(int j = 0; i < playlist.length; j++) {
				if(j == i) {
					
				}else {
					if(playlist[i].getId()== playlist[j].getId()) {
						rnd = rn.nextInt(hasta - desde + 1)+desde;
						playlist[i] = lista.get(rnd);
					}
				}
			}
		}*/
		return playlist;
	}
	public void mostrarPlaylist(int numC) {
		System.out.println("----------CANCIONES-------------");
		for(Cancion ca : generarPlaylist(numC)) {
			
			System.out.println("Id: " + ca.getId());
			System.out.println("Título: " + ca.getTitulo());
			System.out.println("Cantante: " + ca.getCantante());
			System.out.println("Reproducciones: " + ca.getNumRepro());
			System.out.printf("Duración: %.2f\n", ca.getDuracion());
			System.out.println("Gratis: " + ca.isGratis());
			System.out.println("-----------------------");
		}
	}
}
