package servlet;

public class Proyecto {
	Integer id;
	String nombre ;
	String descripcion;
	String rutaimagen;
	String rutaenlace;
	
	public Proyecto(Integer id, String nombre, String descripcion, String rutaimagen, String rutaenlace) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rutaimagen = rutaimagen;
		this.rutaenlace = rutaenlace;
	}
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", Descripcion=" + descripcion + ", rutaimagen="
				+ rutaimagen + ", rutaenlace=" + rutaenlace + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRutaimagen() {
		return rutaimagen;
	}
	public void setRutaimagen(String rutaimagen) {
		this.rutaimagen = rutaimagen;
	}
	public String getRutaenlace() {
		return rutaenlace;
	}
	public void setRutaenlace(String rutaenlace) {
		this.rutaenlace = rutaenlace;
	}
	public Proyecto(String nombre, String descripcion, String rutaimagen, String rutaenlace) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rutaimagen = rutaimagen;
		this.rutaenlace = rutaenlace;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((rutaenlace == null) ? 0 : rutaenlace.hashCode());
		result = prime * result + ((rutaimagen == null) ? 0 : rutaimagen.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (rutaenlace == null) {
			if (other.rutaenlace != null)
				return false;
		} else if (!rutaenlace.equals(other.rutaenlace))
			return false;
		if (rutaimagen == null) {
			if (other.rutaimagen != null)
				return false;
		} else if (!rutaimagen.equals(other.rutaimagen))
			return false;
		return true;
	}
}
