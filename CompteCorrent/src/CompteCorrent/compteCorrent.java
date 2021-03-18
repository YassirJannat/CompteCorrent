package CompteCorrent;

public class compteCorrent {
	
	private int saldo;
	private String contrasenya;
	
	// Constructor
	
	public compteCorrent(int saldoInicial, String cs) {
		this.saldo = saldoInicial;
		this.contrasenya = cs;
	}
	
	/*
	 * Amb aquest metode assignara al saldo x diners i retornara el saldo total
	 */
	
	public int diposita(int pasta) {
		
		saldo = saldo + pasta;
		return saldo;
		
	}
	
	/*
	 * Si els diners són superior al saldo ens retornara -1, si la contrasenya
	 * es incorrecta ens mostrara -2 i si cumplim els requisits anteriors
	 * podrem retirar els diners restant aquests al saldo actual i retornant
	 * el saldo actual
	 */
	
	public int retira(int pasta, String cs) {
		
		if (saldo < pasta) {
			return -1;
		}
		
		if (cs != contrasenya) {
			return -2;
		}
		
		saldo = saldo - pasta;
		
		return saldo;

	}
	
	/*
	 * Ens retornara el saldo sempre que la contrasenya sigui la correcta
	 */
	
	public int getSaldo(String cs) {
		
		int diners = 0;
		if (cs == contrasenya) {
			diners = this.saldo;
		}
		return diners;
	
	}
	
	/*
	 * Si la contrasenya actual es correcta cambiara la contrasenya a la nova i retornara 0
	 * i si introduim la contrasenya incorrecta per cambiar la contrasenya actual retornara -2
	 */
	
	public int setContrasenya(String antiga, String nova) {
		
		if (antiga == contrasenya) {
			contrasenya = nova;
			return 0;
		} else {
			return -2;
		}

	}
}