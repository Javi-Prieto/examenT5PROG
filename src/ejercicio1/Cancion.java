package ejercicio1;

public class Cancion implements Comparable<Cancion>{
	//Fields
	private int id, numRepro;
	private String titulo, cantante;
	private boolean gratis;
	private double duracion;
	
	//Constructor
	public Cancion(int id, int numRepro, String titulo, String cantante, boolean gratis, double duracion) {
		super();
		this.id = id;
		this.numRepro = numRepro;
		this.titulo = titulo;
		this.cantante = cantante;
		this.gratis = gratis;
		this.duracion = duracion;
	}
	
	//Getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumRepro() {
		return numRepro;
	}
	public void setNumRepro(int numRepro) {
		this.numRepro = numRepro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCantante() {
		return cantante;
	}
	public void setCantante(String cantante) {
		this.cantante = cantante;
	}
	public boolean isGratis() {
		return gratis;
	}
	public void setGratis(boolean gratis) {
		this.gratis = gratis;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	//toString
	@Override
	public String toString() {
		return "Cancion [id=" + id + ", numRepro=" + numRepro + ", titulo=" + titulo + ", cantante=" + cantante
				+ ", gratis=" + gratis + "]";
	}
	//Compare
	@Override
	public int compareTo(Cancion o) {
		// TODO Auto-generated method stub
		return -(this.cantante.toLowerCase().compareTo(o.cantante.toLowerCase()));
	}
}
