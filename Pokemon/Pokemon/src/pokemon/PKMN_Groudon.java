package pokemon;

public class PKMN_Groudon extends Pokemon{
static Ataque []ataques = {new Move_Headbutt(), new Move_Earthquake(), new Move_Earthquake(), new Move_Cut()};
	
	public PKMN_Groudon(){
		super("Groudon", "Ground", 350, 350, ataques);
	}

}
