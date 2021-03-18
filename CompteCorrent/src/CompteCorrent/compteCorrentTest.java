package CompteCorrent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class compteCorrentTest {

	/*
	 * Depositarem x diners al compte amb una contrasenya x 
	 */
	
	@Test
	void testDiposita() {
		
		int resultatActual;
		int resultatEsperat;

		compteCorrent miCuenta = new compteCorrent(1000, "miClave");
		
		resultatActual = miCuenta.diposita(500);
		
		resultatEsperat = 1500;
		
		assertEquals(resultatEsperat, resultatActual, "Error en dipositar diners");
	}

	/*
	 * Intentara retirar mes diners dels que hi han al banc
	 * i per aquest motiu retornara -1 
	 */
	
	@Test
	void testRetiraSaldoIncorrecte() {
		
		int saldoInicial = 1000;
		int dinersRetirar = 1100;
		int resultatEsperat = -1;
		int resultatActual;
		
		compteCorrent miCuenta = new compteCorrent(saldoInicial, "miClave");
		
		resultatActual = miCuenta.retira(dinersRetirar, "miClave");
		
		assertEquals(resultatEsperat, resultatActual, "S'esperava que no funciones suposant que no hi ha prou saldo");
		
	}
	
	/*
	 * Intentara retirar diners per la contrasenya es incorrecta llavors retornana -2
	 */
	
	@Test
	void testRetiraContrasenyaIncorrecta() {
		
		int saldoInicial = 1000;
		int dinersRetirar = 500;
		int resultatEsperat = -2;
		int resultatActual;
		String contrasenyaCorrecta = "miClave";
		String contrasenyaIncorrecta = "0000";
		
		compteCorrent miCuenta = new compteCorrent(saldoInicial, contrasenyaCorrecta);
		
		resultatActual = miCuenta.retira(dinersRetirar, contrasenyaIncorrecta);
		
		assertEquals(resultatEsperat, resultatActual, "No s'ha detectat que la contrasenya era falsa");
		
	}
	
	/*
	 * Retirarem menys diners dels que hihan al compte sempre que
	 * la contrasenya estigue correcta com en aquest cas
	 */
	
	@Test
	void testRetiraOK() {
		
		int saldoInicial = 1000;
		int dinersRetirar = 500;
		int resultatEsperat = saldoInicial - dinersRetirar;
		int resultatActual;
		
		compteCorrent miCuenta = new compteCorrent(saldoInicial, "miClave");
		
		resultatActual = miCuenta.retira(dinersRetirar, "miClave");
		
		assertEquals(resultatEsperat, resultatActual, "S'esperava que retornes 500 de saldo");
		
	}
	
	/*
	 * Ens retorna el saldo actual sempre que la contrasenya sigui correcta
	 */
	
	@Test
	void testGetSaldo() {
		int resultatActual;
		int resultatCorrecte;
		String ContrasenyaActual = "miClave";
		int saldo = 1000;

		compteCorrent meuCompte = new compteCorrent(saldo, ContrasenyaActual);

		resultatActual = meuCompte.getSaldo(ContrasenyaActual);
		resultatCorrecte = saldo;

		assertEquals(resultatActual, resultatCorrecte, "Hauria d'haver tornat el saldo");
	
	}
	
	/*
	 * Conseguirem cambiar la contrasenya actual satisfactoriament ja que
	 * coneixem la actual contrasenya com a requisit per cambiar la contrasenya
	 */
	
	@Test	
	void testSetContrasenyaCorrecta() {
		int resultatActual;
		int resultatEsperat;
		String contrasenyaActual = "miClave";
		String contrasenyaAntiga = "miClave";
		String contrasenyaNova = "02";

		compteCorrent miCuenta = new compteCorrent(1500, contrasenyaActual);

		resultatActual = miCuenta.setContrasenya(contrasenyaAntiga, contrasenyaNova);
		resultatEsperat= 0;

		assertEquals(resultatActual, resultatEsperat, "S'ha modificat correctament la contrasenya");
	}

	/*
	 * Al intentar cambiar la contrasenya actual a una nova ens donara
	 * error ja que no sabem la contrasenya actual com a requisit per
	 * cambiar la contrasenya
	 */
	
	@Test
	void testSetNoContrasenya() {
		
		int resultatActual;
		int resultatEsperat;
		String contrasenyaActual = "miClave";
		String contrasenyaAntiga = "01";
		String contrasenyaNova = "02";

		compteCorrent miCuenta = new compteCorrent(1500, contrasenyaActual);

		resultatActual = miCuenta.setContrasenya(contrasenyaAntiga, contrasenyaNova);
		resultatEsperat = -2;

		assertEquals(resultatActual, resultatEsperat, " La contrasenya es incorrecta");
		
	}

}
