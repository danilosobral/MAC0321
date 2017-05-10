package pokemon;

import java.util.Scanner;

public class Trainer_Usuario extends Treinador{
	private int i = 0;
	private static Pokemon[] pokemon = {new PKMN_Pikachu(), new PKMN_Eevee(), new PKMN_Kyogre(), new PKMN_Articuno(), new PKMN_Mew()};
	private float alfa;
	
	public Trainer_Usuario(String nome) {
		super(nome, pokemon, false);
	}
	
	public int estrategia() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o numero referente ao que "+ getNome() +" quer fazer\n1: Fugir\n2: Trocar Pokemon\n3: Curar Pokemon\n4: Atacar");
		int n = input.nextInt();
		if(n == 4) {
			System.out.println("Digite o numero referente ao ataque escolhido:");
			int i;
			for(i = 0; i<this.pokemonAtivo.ataques.length; i++) {
				System.out.println((i+1) + ": "+ this.pokemonAtivo.ataques[i].getNome());
			}
			input = new Scanner(System.in);
			this.pokemonAtivo.setAtaque(pokemonAtivo.ataques[input.nextInt() - 1]);
		}
		return(n);
	}
}
