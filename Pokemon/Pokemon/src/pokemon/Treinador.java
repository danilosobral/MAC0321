package pokemon;

import java.util.Scanner;

abstract public class Treinador {
	private static final int CURA = 20;
	private String nome;
	private Pokemon[] pokemon;
	private boolean CPU;
	private int qtdPokemonVivo;
	protected Pokemon pokemonAtivo;
	protected double [][]peso = {{1, 1, 1, 1, 1, 0.5, 1, 0, 0.5, 1, 1, 1, 1, 1, 1}, 
								 {2, 1, 0.5, 0.5, 1, 2, 0.5, 0, 2, 1, 1, 1, 1, 0.5, 2}, 
								 {1, 2, 1, 1, 1, 0.5, 2, 1, 0.5, 1, 1, 2, 0.5, 1, 1},
								 {1, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 0, 1, 1, 2, 1, 1, 1}, 
								 {1, 1, 0, 2, 1, 2, 0.5, 1, 2, 2, 1, 0.5, 2, 1, 1}, 
								 {1, 0.5, 2, 1, 0.5, 1, 2, 1, 0.5, 2, 1, 1, 1, 1, 2},
								 {1, 0.5, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 0.5, 1, 2, 1, 2, 1}, 
								 {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1},
								 {1, 1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 0.5, 1, 0.5, 1, 2},
								 {1, 1, 1, 1, 1, 0.5, 2, 1, 2, 0.5, 0.5, 2, 1, 1, 2}, 
								 {1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 0.5, 0.5, 1, 1, 1},
								 {1, 1, 0.5, 0.5, 2, 2, 0.5, 1, 0.5, 0.5, 2, 0.5, 1, 1, 1},
								 {1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 0.5, 0.5, 1, 1},
								 {1, 2, 1, 2, 1, 1, 1, 1, 0.5, 1, 1, 1, 1, 0.5, 1},
								 {1, 1, 2, 1, 2, 1, 1, 1, 0.5, 0.5, 0.5, 2, 1, 1, 0.5}};

	
	private int j = 0;
	
	public Treinador (String nome, Pokemon []pokemon, boolean cpu) {
		this.nome = nome;
		this.CPU = cpu;
		this.pokemon = pokemon;
		qtdPokemonVivo = pokemon.length;
		this.setPokemonAtivo();
	}
	
	public String getNome(){
		return nome;
	}
	public Pokemon getPokemonAtivo() {
		return pokemonAtivo;
	}
	
	public void usarPocao() {
		pokemonAtivo.curado(CURA);
		//System.out.println(pokemonAtivo.getNome()+" tem "+pokemonAtivo.getVida()+" de vida apos a cura");
	}

	public int getNumeroPokemonVivos() {
		return qtdPokemonVivo;
	}
	
	public void pokemonMorreu() {
		qtdPokemonVivo--;
		if(qtdPokemonVivo >= 1) setPokemonAtivo();
	}
	
	public void setPokemonAtivo() {
		if(this.CPU) {//Caso o treinador seja controlado pelo computador
			if(j >= pokemon.length) j = 0;
			pokemonAtivo = pokemon[j++]; //Pega o proximo pokemon disponivel. Se chegou no fim, volta ao inicio do vetor
		}
		else {// Caso o treinador seja controlado pelo usuário
			int i;
			System.out.println("Digite o numero referente ao pokemon que voce quer:");
			for(i = 0; i < pokemon.length; i++) {
				System.out.println((i+1) +": "+pokemon[i].getNome());
			}
			Scanner input = new Scanner(System.in);
			pokemonAtivo = pokemon[input.nextInt() - 1];
		}
	}
	
	public double getPeso(String tipoAtaque, String tipoDefesa) {
		int i = 0, j = 0;
		switch(tipoAtaque) {
			case "Normal": 
				i = 0;
				break;
			case "Fight" :
				i = 1;
				break;
			case "Flying" :
				i = 2;
				break;			
			case "Poison" :
				i = 3;
				break;
			case "Ground" :
				i = 4;
				break;
			case "Rock" :
				i = 5;
				break;
			case "Bug" :
				i = 6;
				break;
			case "Ghost" :
				i = 7;
				break;
			case "Steel" :
				i = 8;
				break;
			case "Fire" :
				i = 9;
				break;
			case "Water" :
				i = 10;
				break;
			case "Grass" :
				i = 11;
				break;
			case "Electric" :
				i = 12;
				break;
			case "Psychic" :
				i = 13;
				break;
			case "Ice" :
				i = 14;
				break;
		}
		
		switch(tipoDefesa) {
			case "Normal": 
				j = 0;
				break;
			case "Fight" :
				j = 1;
				break;
			case "Flying" :
				j = 2;
				break;			
			case "Poison" :
				j = 3;
				break;
			case "Ground" :
				j = 4;
				break;
			case "Rock" :
				j = 5;
				break;
			case "Bug" :
				j = 6;
				break;
			case "Ghost" :
				j = 7;
				break;
			case "Steel" :
				j = 8;
				break;
			case "Fire" :
				j = 9;
				break;
			case "Water" :
				j = 10;
				break;
			case "Grass" :
				j = 11;
				break;
			case "Electric" :
				j = 12;
				break;
			case "Psychic" :
				j = 13;
				break;
			case "Ice" :
				j = 14;
				break;
		}
		/*A matriz peso representa um multiplicador de acordo com o tipo do pokemon.
		 * O tipo de ataque corresponde a uma linha e o tipo de defesa a uma coluna. 
		 * Assim, para encontrar qual sera o multiplicador do golpe, basta pegar a linha correspondente ao tipo do ataque com a coluna correspondente ao de defesa.
		 * */
		return peso[i][j];
	}
	
	public void atacar(Pokemon pokemon1, Pokemon pokemon2){
		pokemon2.apanha(pokemon1.getAtaque().getDano() * getPeso(pokemon1.getTipo(), pokemon2.getTipo()));
	}
	
	abstract public int estrategia(); //Define a estrategia do treinador
}