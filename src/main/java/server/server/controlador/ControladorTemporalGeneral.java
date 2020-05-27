package server.server.controlador;

public class ControladorTemporalGeneral<T> {

	private EmpresasControlador<T> empresa;
	private GeneroControlador<T> genero;
	private JuegosControlador<T> juegos;
	private UsuarioControlador<T> user;
	
	public ControladorTemporalGeneral() {
		setEmpresa(new EmpresasControlador<T>());
		setGenero(new GeneroControlador<T>());
		setJuegos(new JuegosControlador<T>());
		setUser(new UsuarioControlador<T>());
	}

	public EmpresasControlador<T> getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresasControlador<T> empresa) {
		this.empresa = empresa;
	}

	public GeneroControlador<T> getGenero() {
		return genero;
	}

	public void setGenero(GeneroControlador<T> genero) {
		this.genero = genero;
	}

	public JuegosControlador<T> getJuegos() {
		return juegos;
	}

	public void setJuegos(JuegosControlador<T> juegos) {
		this.juegos = juegos;
	}

	public UsuarioControlador<T> getUser() {
		return user;
	}

	public void setUser(UsuarioControlador<T> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ControladorTemporalGeneral [empresa=" + empresa + ", genero=" + genero + ", juegos=" + juegos
				+ ", user=" + user + "]";
	}
	
	public static void main(String [] args) {
		@SuppressWarnings("rawtypes")
        ControladorTemporalGeneral<ControladorTemporalGeneral> ctg = new ControladorTemporalGeneral<ControladorTemporalGeneral>();
		System.out.println(ctg.getJuegos().findById(1));
	}
}
