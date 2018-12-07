package procesos;

public class Usuario {
    private String Usuario;
	private String Nombre;
	private String ApellidoM;
	private String ApellidoP;
	private String Password;
	private String Question;
	private String Answer;

	public Usuario() {
	}
	//get...
	public String getUsuario() {
		return Usuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getApellidoM() {
		return ApellidoM;
	}
	public String getApellidoP() {
		return ApellidoP;
	}
	public String getPassword_segurity() {
		return Password;
	}
	public String getQuestion_segurity() {
		return Question;
	}
	public String getAnswer_segurity() {
		return Answer;
	}
	//set...
	public void setUsuario(String Usu) {
		this.Usuario=Usu;
	}
	public void setNombre(String Nom) {
		this.Nombre=Nom;
	}
	public void setApellidoM(String ApM) {
		this.ApellidoM=ApM;
	}
	public void setApellidoP(String ApP) {
		this.ApellidoP=ApP;
	}
	public void setPassword_segurity(String Pass) {
		this.Password=Pass;
	}
	public void setQuestion_segurity(String Que) {
		this.Question=Que;
	}
	public void setAnswer_segurity(String Ans) {
		this.Answer=Ans;
	}
}
