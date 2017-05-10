package pokemon;

public class PKMN_Eevee extends Pokemon{
	static Ataque []ataque =  {new Move_Headbutt(), new Move_Slash(), new Move_Cut(), new Move_Confusion()};

	public PKMN_Eevee(){
		super("Eevee", "Normal", 200, 200, ataque);
	}
}
