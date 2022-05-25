package puertos.entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Un barco que transporta carga entre puertos, tiene buena capacidad de carga.
 * 
 * @version 3.0
 */
@Entity
@DiscriminatorValue("carguero")
public class Carguero extends Barco {
	private boolean liquidos;

	/**
	 * @see puertos.entidades.Barco#Barco(String, String, double)
	 * @param liquidos	indicación de si puede llevar líquidos o no
	 */
	Carguero(String matricula, String nacionalidad, double volumen,
			boolean liquidos) {
		super(matricula, nacionalidad, volumen);
		this.liquidos = liquidos;
	}
	
	public Carguero() {
		// Constructor usado por el Orm
	}

	public boolean getLiquidos() {
		return this.liquidos;
	}

	public void setLiquidos(boolean liquidos) {
		this.liquidos = liquidos;
	}

	@Override
	public double calcularCapacidad() {
		double capacidad = getVolumen() * 0.8;
		if (this.liquidos) {
			capacidad-= 40;
		}
		return (capacidad < 0) ? 0 : capacidad;
	}
}
