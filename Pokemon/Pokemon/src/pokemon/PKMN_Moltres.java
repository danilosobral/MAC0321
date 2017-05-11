package pokemon;

public class PKMN_Moltres extends Pokemon{
	static Ataque []ataques = {new Move_Fly(), new Move_FireSpin(), new Move_Cut(), new Move_FireSpin()};
		
		public PKMN_Moltres(){
			super("Moltres", "Fire", 350, 350, ataques);
		}
}
