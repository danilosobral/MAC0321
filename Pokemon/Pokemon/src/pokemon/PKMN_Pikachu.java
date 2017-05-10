package pokemon;

public class PKMN_Pikachu extends Pokemon {
	static Ataque []ataque =  {new Move_Headbutt(), new Move_Cut(), new Move_Slash(), new Move_ThunderPunch()};

	public PKMN_Pikachu(){
		super("Pikachu", "Electric", 200, 200, ataque);
	}
	
	
	
}
