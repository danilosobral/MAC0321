package pokemon;

public class PKMN_Totodile extends Pokemon{
	static Ataque []ataques = {new Move_Surf(), new Move_Cut(), new Move_IceWind(), new Move_Headbutt()};
	
	public PKMN_Totodile(){
		super("Totodile", "Water", 250, 250, ataques);
	}
}
