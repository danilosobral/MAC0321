package pokemon;

public class Trainer_Ash extends Treinador{
	private int i = 0;
	private static Pokemon[] pokemon = {new PKMN_Pikachu(), new PKMN_Eevee(), new PKMN_Kyogre(), new PKMN_Articuno(), new PKMN_Mew()};
	private float alfa;
	
	public Trainer_Ash() {
		super("Ash", pokemon, true);
	}
	
	public int estrategia() {
		/* A estrategia eh definida de acordo com a porcentagem de vida que ainda resta ao pokemon (representado por alfa)
		 * e com a quantidade de pokemons o treinador ainda tem
		 */
		alfa = (float)getPokemonAtivo().getVida()/getPokemonAtivo().getVidaMax();
		//System.out.println("Vida de "+ getPokemonAtivo().getNome() + ": "+ getPokemonAtivo().getVida());
		//System.out.println("Vida max de "+ getPokemonAtivo().getNome() + ": "+getPokemonAtivo().getVidaMax());
		//System.out.println("Alfa de "+ getPokemonAtivo().getNome() + ": "+alfa+"\n");
		if(alfa < 0.25 && alfa >= 0.1){
			if(this.getNumeroPokemonVivos() > 1)
				return 2; // troca pokemon
			else return 4;
		}

		else if(alfa < 0.1 && this.getNumeroPokemonVivos() == 1){
			return 1; // foge!!!
		}

		else if(alfa >= 0.25 && alfa < 0.5) {
			return 3; // cura pokemon
		}

		else{
			if(i > 3) i = 0;
			this.getPokemonAtivo().setAtaque(this.getPokemonAtivo().ataques[i++]); // a cada iteracao escolhe um ataque
			return 4; // ataca!
		}
	}
}
