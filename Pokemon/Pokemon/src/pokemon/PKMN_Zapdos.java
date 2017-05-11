package pokemon;

public class PKMN_Zapdos extends Pokemon{
static Ataque []ataques = {new Move_ThunderPunch(), new Move_Fly(), new Move_Cut(), new Move_Headbutt()};
	
	public PKMN_Zapdos(){
		super("Zapdos", "Electric", 350, 350, ataques);
	}
}
