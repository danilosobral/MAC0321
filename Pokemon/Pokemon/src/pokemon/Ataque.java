package pokemon;

public abstract class Ataque {
	private String nome;
	private int danoCausado;
	
	public Ataque(String n, int dano) {
		nome = n;
		this.danoCausado = dano;
	}
	
	public int getDano() {
		return danoCausado;
	}
	
	public String getNome() {
		return nome;
	}
}
