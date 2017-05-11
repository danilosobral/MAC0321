package pokemon;

public class PKMN_Golem extends Pokemon{
	static Ataque []ataques = {new Move_Earthquake(), new Move_Headbutt(), new Move_Slash(), new Move_Cut()};
		
		public PKMN_Golem(){
			super("Golem", "Rock", 250, 250, ataques);
		}
}
