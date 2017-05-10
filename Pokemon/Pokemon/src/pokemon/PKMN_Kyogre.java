package pokemon;

public class PKMN_Kyogre extends Pokemon{
static Ataque []ataques = {new Move_Surf(), new Move_Confusion(), new Move_Headbutt(), new Move_IceWind()};
	
	public PKMN_Kyogre(){
		super("Kyogre", "Water", 350, 350, ataques);
	}
}
