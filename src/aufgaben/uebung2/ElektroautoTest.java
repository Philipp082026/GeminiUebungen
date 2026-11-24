package aufgaben.uebung2;

public class ElektroautoTest {

	public static void main(String[] args) {
		
		Elektroauto e1 = new Elektroauto("ID.3", 60.0, 15.0);
		e1.laden(-10.0);
		e1.laden(20.0);
		e1.laden(50.0);
		e1.status();
		e1.fahren(500.0);
		e1.fahren(200.0);
		e1.status();
		System.out.printf("%n%n------------------------- Zusatz ---------------------------------%n%n");
		e1.wartungPruefen();
		e1.schnellladen(10);
		e1.status();
		e1.fahren(350.0);
		e1.laden(60.0);
		e1.fahren(500.0); // klappt noch nicht ganz bei 60 kWh, wir fahren 350 km + 350 km:
		e1.fahren(350.0);
		e1.laden(60.0);
		e1.fahren(150.0);
		e1.wartungPruefen();
	}
}
