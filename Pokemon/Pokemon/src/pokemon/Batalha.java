package pokemon;

import java.util.Scanner;

public class Batalha extends Controller{

	private class Fuga extends Event {
		private Treinador t1, t2;
		public Fuga(long eventTime, Treinador t1, Treinador t2) {
			super(eventTime);
			this.t1 = t1;
			this.t2 = t2;
		}

		public void action() {
			addEvent(new EndBatalha(evtTime, t2, t1));
		}

		public String description() {
			return "O treinador " +t1.getNome()+" fugiu!";
		}
	}

	private class TrocarPokemon extends Event {
		private Treinador t1, t2;
		public TrocarPokemon(long eventTime, Treinador t1, Treinador t2) {
			super(eventTime);
			this.t1 = t1;
			this.t2 = t2;
		}

		public void action(){
			t1.setPokemonAtivo();
		}

		public String description() {
			return t1.getPokemonAtivo().getNome()+" do treinador "+t1.getNome()+ " entrou em batalha!";
		}

	}

	private class UsarItem extends Event {
		private Treinador t1, t2;
		public UsarItem(long eventTime, Treinador t1, Treinador t2) {
			super(eventTime);
			this.t1 = t1;
			this.t2 = t2;
		}

		public void action() {
			t1.usarPocao();
		}

		public String description() {
			return t1.getNome() +" curou "+ t1.getPokemonAtivo().getNome();
		}
	}

	private class Ataque extends Event {
		private Treinador t1, t2;
		public Ataque(long eventTime, Treinador t1, Treinador t2) {
			super(eventTime);
			this.t1 = t1;
			this.t2 = t2;
		}
		
		public void action() {
			t1.atacar(t1.getPokemonAtivo(), t2.getPokemonAtivo());
			if(t2.pokemonAtivo.getVida() == 0) {
				t2.pokemonMorreu();
			}
			
			if(t2.getNumeroPokemonVivos() == 0) { //Caso todos os pokemons do adversario tenham morrido
				addEvent(new EndBatalha(evtTime, t1, t2));
			}
				
		}

		public String description() {
			return t1.pokemonAtivo.getNome() +" usou "+t1.getPokemonAtivo().getAtaque().getNome() +"\n"+ t1.pokemonAtivo.getNome() + " causou "+t1.getPokemonAtivo().getAtaque().getDano()*t1.getPeso(t1.pokemonAtivo.getTipo(),  t2.pokemonAtivo.getTipo())+ " de dano a "+ t2.pokemonAtivo.getNome();
		}
	}

	private class EndBatalha extends Event {
		private Treinador t1, t2;
		public EndBatalha(long eventTime, Treinador t1, Treinador t2) {
			super(eventTime);
			this.t1 = t1;
			this.t2 = t2;
		}

		public void action() {
			endBatalha = true;
		}

		public String description() {
			return "O treinador "+t1.getNome()+" venceu!";
		}
	}

	public int nRound = 0;

	private class StartRound extends Event {
		private Treinador t1, t2;
		long tm = System.currentTimeMillis();
		public StartRound (long eventTime, Treinador t1, Treinador t2){
			super(eventTime);
			this.t1 = t1;
			this.t2 = t2;
		}

		public void action() {
			/* O evento de cada round depende da estrategia do treinador, 
			 * que avaliara o que fazer de acordo com a saude do seu pokemon
			 */
			switch(t1.estrategia()){
				case 4: addEvent(new Ataque(tm + 400, t1, t2));
						break;
				case 3: addEvent(new UsarItem(tm + 300, t1, t2));
						break;
				case 2: addEvent(new TrocarPokemon(tm + 200, t1, t2));
						break;
				case 1: addEvent(new Fuga(tm + 100, t1, t2));
			}
			switch(t2.estrategia()){
				case 4: addEvent(new Ataque(tm + 400, t2, t1));
						break;
				case 3: addEvent(new UsarItem(tm + 300, t2, t1));
						break;
				case 2: addEvent(new TrocarPokemon(tm + 200, t2, t1));
						break;
				case 1: addEvent(new Fuga(tm + 100, t2, t1));
			}
		}

		public String description() {
			System.out.println("Vida de "+ t1.getPokemonAtivo().getNome() + ": "+ t1.getPokemonAtivo().getVida());
			System.out.println("Vida de "+ t2.getPokemonAtivo().getNome() + ": "+ t2.getPokemonAtivo().getVida());
			return "\nComeça o round " +(++nRound) + "\n";
		}
	}

	public static void main(String [] argc) {
		Batalha bt = new Batalha();
		Scanner input = new Scanner(System.in);
		int nJogadores;		
		long tm = System.currentTimeMillis();
		Treinador t1, t2;
		
		System.out.println("Digite o numero de jogadores:\n0 (CPU vs CPU)\n1 (Usuario vs CPU)\n2 (Usuario vs Usuario)");
		nJogadores = input.nextInt();
		if(nJogadores == 0) {
			t1 = new Trainer_Ash();
			t2 = new Trainer_Brock();
		} 
		else if(nJogadores == 1) {
			System.out.println("Digite o seu nome:");
			input = new Scanner(System.in);
			t1 = new Trainer_Usuario(input.nextLine());
			t2 = new Trainer_Ash();
		}
		else {
			System.out.println("Digite o seu nome:");
			input = new Scanner(System.in);
			t1 = new Trainer_Usuario(input.next());
			System.out.println("Digite o nome do seu adversario:");
			input = new Scanner(System.in);
			t2 = new Trainer_Usuario(input.nextLine());
		}
		// Enquanto nao houver fuga ou derrota, inicia-se um round
		while(!bt.endBatalha) {
			bt.addEvent(bt.new StartRound(tm, t1, t2));
			bt.run();
		}
	}
}
