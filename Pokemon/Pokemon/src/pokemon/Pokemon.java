package pokemon;

public abstract class Pokemon {
	
	private String nome;
	private String tipo;
	private int HPmax;
	private int HP;
	public /*private*/ Ataque[] ataques;
	private Ataque ataqueEscolhido = null;
	
	public Pokemon(String nome, String tipo, int HP, int HPmax, Ataque[] ataque) {
		this.nome = nome;
		this.tipo = tipo;
		this.HP = HP;
		this.HPmax = HPmax;
		this.ataques = ataque;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getVida() {
		return this.HP;
	}
	
	public int getVidaMax() {
		return this.HPmax;
	}
	
	public String getTipo() {
		return this.tipo;
	}

	public void apanha(double dano) {
		//System.out.println("NA FUNCAO APANHA DE POKEMON: Vida Antes: "+HP+ " (de "+ this.getNome()+")");
		HP -= dano;
		//System.out.println("VIDA DEPOIS: "+HP+ " (de "+ this.getNome()+")");
	}
	
	public void curado(int cura) {
		HP += cura;
		if(HP > HPmax) HP = HPmax;
	}
	
	public void setAtaque(Ataque ataque) {
		ataqueEscolhido = ataque;
	}
	
	public Ataque getAtaque(){
		return ataqueEscolhido;
	}
}
