package pokemon;

public class PKMN_Articuno extends Pokemon{
static Ataque []ataques = {new Move_Fly(), new Move_Cut(), new Move_IceWind(), new Move_Slash()};
	
	public PKMN_Articuno(){
		super("Articuno", "Ice", 350, 350, ataques);
	}
}
