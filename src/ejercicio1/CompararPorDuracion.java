package ejercicio1;

import java.util.Comparator;

public class CompararPorDuracion implements Comparator<Cancion>{

	@Override
	public int compare(Cancion o1, Cancion o2) {
		if(o1.getDuracion()>o2.getDuracion()) {
			return 1;
		}else {
			if(o1.getDuracion()<o2.getDuracion()) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	
}
