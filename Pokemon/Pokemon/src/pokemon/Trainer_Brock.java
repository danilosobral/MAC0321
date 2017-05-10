package pokemon;

public class Trainer_Brock extends Treinador {
	private int i = 0;
	static Pokemon[] pokemon = {new PKMN_Totodile(), new PKMN_Moltres(), new PKMN_Golem(), new PKMN_Groudon(), new PKMN_Zapdos()};
	
	public Trainer_Brock() {
		super("Brock", pokemon, true);
	}
	
	public int estrategia() {
		float alfa = (float)this.getPokemonAtivo().getVida()/this.getPokemonAtivo().getVidaMax();
		//System.out.println("Vida de "+ getPokemonAtivo().getNome() + ": "+ getPokemonAtivo().getVida());
		//System.out.println("Vida max de "+ getPokemonAtivo().getNome() + ": "+getPokemonAtivo().getVidaMax());
		//System.out.println("Alfa de "+ getPokemonAtivo().getNome() + ": "+alfa+"\n");

		if(alfa < 0.2 && alfa >= 0.1){
			return 2; // troca pokemon
		}

		if(alfa < 0.1){
			return 1; // foge!!!
		}

		if(alfa < 0.3 && alfa >= 0.2) {
			return 3; // cura pokemon
		}
		
		else {
			if(i > 3) i = 0;
			this.getPokemonAtivo().setAtaque(this.getPokemonAtivo().ataques[i++]); // a cada iteracao escolhe um ataque
			return 4; // ataca!
		}
	}
}
