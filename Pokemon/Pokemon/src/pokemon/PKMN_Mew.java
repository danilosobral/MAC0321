package pokemon;

public class PKMN_Mew extends Pokemon{
static Ataque []ataques = {new Move_Confusion(), new Move_Headbutt(), new Move_Fly(), new Move_Cut()};
	
	public PKMN_Mew(){
		super("Mew", "Psychic", 350, 350, ataques);
	}
}
