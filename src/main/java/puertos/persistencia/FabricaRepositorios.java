package puertos.persistencia;

/**
 * Permite crear un repositorio para los barcos, de acuerdo con el tipo dado,
 * desacoplando así la clase de control de cada tipo de repositorio concreto.
 * Corresponde al patrón de diseño "SIMPLE FACTORY".
 * 
 * @version 1.0
 */
public class FabricaRepositorios {
	
	/**
	 * Crea un repositorio (objeto que cumple con la interfaz RepositorioBarcos).
	 * 
	 * @param tipo el tipo de repositorio que se desea crear, 
	 * 	por ejemplo: "Lista", "Orm".
	 * @return el objeto RepositorioBarcos del tipo definido.
	 * 	Si no se recibe un tipo reconocido, se devuelve una lista 
	 * 	(repositorio "falso", en memoria).
	 */
	public RepositorioBarcos crearRepositorio(String tipo) {
		switch (tipo) {
		  case "Orm", "ORM", "orm":
			  return new OrmBarcos();
		  case "Lista", "LISTA", "lista":
		  default:
			  return new ListaBarcos();
		}
	}

}
