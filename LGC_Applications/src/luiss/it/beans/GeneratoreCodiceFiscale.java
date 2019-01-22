package luiss.it.beans;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class GeneratoreCodiceFiscale {

	private String Cognome;
	private String Nome;
	private Date DataDiNascita;
	private String Sesso;
	private String CodiceCatastale;
	private static String CaratteriValidi = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static String[] MESI = { "?", "A", "B", "C", "D", "E", "H", "L", "M", "P", "R", "S", "T" };
	private static String[] RESTO = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
	private static String VOCALI = "AEIOU";
	private static String CONSONANTI = "BCDFGHJKLMNPQRSTVWXYZ";

	public GeneratoreCodiceFiscale() {
		
	}
	
	public GeneratoreCodiceFiscale(String Cognome, String Nome, Date DataDiNascita, String Sesso,
			String CodiceCatastale) throws GeneratoreCodiceFiscaleException {

		Cognome = Cognome.replaceAll(" ", "");
		Nome = Nome.replaceAll(" ", "");

		if (Cognome == null || Cognome.trim().length() <= 0) {
			throw new GeneratoreCodiceFiscaleException("Cognome null or empty");
		} else {
			this.Cognome = Cognome.trim().toUpperCase();
		}

		if (Nome == null || Nome.trim().length() <= 0) {
			throw new GeneratoreCodiceFiscaleException("Nome null or empty");
		} else {
			this.Nome = Nome.trim().toUpperCase();
		}

		if (DataDiNascita == null) {
			throw new GeneratoreCodiceFiscaleException("DataDiNascita null");
		}

		this.DataDiNascita = DataDiNascita;

		if (Sesso == null || Sesso.trim().length() <= 0) {
			throw new GeneratoreCodiceFiscaleException("Sesso null or empty");
		} else {
			if ((!Sesso.equals("M")) && (!Sesso.equals("F"))) {
				throw new GeneratoreCodiceFiscaleException("Wrong sesso");
			} else {
				this.Sesso = Sesso;
			}
		}

		if (CodiceCatastale == null || CodiceCatastale.trim().length() <= 0) {
			throw new GeneratoreCodiceFiscaleException("LuogoDiNascita null or empty");
		} else {
			this.CodiceCatastale = CodiceCatastale.trim().toUpperCase();
		}

	}

	private int Pari(String carattere) throws GeneratoreCodiceFiscaleException {

		int intero = -1;

		switch (carattere) {
		case "0":
			intero = 0;
			break;
		case "1":
			intero = 1;
			break;
		case "2":
			intero = 2;
			break;
		case "3":
			intero = 3;
			break;
		case "4":
			intero = 4;
			break;
		case "5":
			intero = 5;
			break;
		case "6":
			intero = 6;
			break;
		case "7":
			intero = 7;
			break;
		case "8":
			intero = 8;
			break;
		case "9":
			intero = 9;
			break;
		case "A":
			intero = 0;
			break;
		case "B":
			intero = 1;
			break;
		case "C":
			intero = 2;
			break;
		case "D":
			intero = 3;
			break;
		case "E":
			intero = 4;
			break;
		case "F":
			intero = 5;
			break;
		case "G":
			intero = 6;
			break;
		case "H":
			intero = 7;
			break;
		case "I":
			intero = 8;
			break;
		case "J":
			intero = 9;
			break;
		case "K":
			intero = 10;
			break;
		case "L":
			intero = 11;
			break;
		case "M":
			intero = 12;
			break;
		case "N":
			intero = 13;
			break;
		case "O":
			intero = 14;
			break;
		case "P":
			intero = 15;
			break;
		case "Q":
			intero = 16;
			break;
		case "R":
			intero = 17;
			break;
		case "S":
			intero = 18;
			break;
		case "T":
			intero = 19;
			break;
		case "U":
			intero = 20;
			break;
		case "V":
			intero = 21;
			break;
		case "W":
			intero = 22;
			break;
		case "X":
			intero = 22;
			break;
		case "Y":
			intero = 24;
			break;
		case "Z":
			intero = 25;
			break;
		default:
			intero = -1;
			break;
		}

		if (intero == -1) {
			throw new GeneratoreCodiceFiscaleException("Wrong pari");
		}

		return intero;

	}

	private int Dispari(String carattere) throws GeneratoreCodiceFiscaleException {

		int intero = -1;

		switch (carattere) {
		case "0":
			intero = 1;
			break;
		case "1":
			intero = 0;
			break;
		case "2":
			intero = 5;
			break;
		case "3":
			intero = 7;
			break;
		case "4":
			intero = 9;
			break;
		case "5":
			intero = 13;
			break;
		case "6":
			intero = 15;
			break;
		case "7":
			intero = 17;
			break;
		case "8":
			intero = 19;
			break;
		case "9":
			intero = 21;
			break;
		case "A":
			intero = 1;
			break;
		case "B":
			intero = 0;
			break;
		case "C":
			intero = 5;
			break;
		case "D":
			intero = 7;
			break;
		case "E":
			intero = 9;
			break;
		case "F":
			intero = 13;
			break;
		case "G":
			intero = 15;
			break;
		case "H":
			intero = 17;
			break;
		case "I":
			intero = 19;
			break;
		case "J":
			intero = 21;
			break;
		case "K":
			intero = 2;
			break;
		case "L":
			intero = 4;
			break;
		case "M":
			intero = 18;
			break;
		case "N":
			intero = 20;
			break;
		case "O":
			intero = 11;
			break;
		case "P":
			intero = 3;
			break;
		case "Q":
			intero = 6;
			break;
		case "R":
			intero = 8;
			break;
		case "S":
			intero = 12;
			break;
		case "T":
			intero = 14;
			break;
		case "U":
			intero = 16;
			break;
		case "V":
			intero = 10;
			break;
		case "W":
			intero = 22;
			break;
		case "X":
			intero = 25;
			break;
		case "Y":
			intero = 24;
			break;
		case "Z":
			intero = 23;
			break;
		default:
			intero = -1;
			break;
		}

		if (intero == -1) {
			throw new GeneratoreCodiceFiscaleException("Wrong dispari: " + carattere);
		}

		return intero;

	}

	private boolean isValid(String str, String pattern) {

		boolean valido = true;

		for (int i = 0; i < str.length(); i++) {
			int s = i;
			int e = i + 1;
			if (!pattern.contains(str.substring(s, e))) {
				valido = false;
			}
		}

		return valido;

	}

	public String Cacola() throws GeneratoreCodiceFiscaleException {

		StringBuffer codiceFiscale = new StringBuffer();

		codiceFiscale.append(this.ElaboraCognome());

		codiceFiscale.append(this.ElaboraNome());
		codiceFiscale.append(this.getAnnoNascita());
		codiceFiscale.append(this.getMeseNascita());
		codiceFiscale.append(this.getGiornoNascita());
		codiceFiscale.append(this.CodiceCatastale);
		codiceFiscale.append(this.getCarattereDiControllo(codiceFiscale.toString(), false));

		if (codiceFiscale.length() != 16) {
			throw new GeneratoreCodiceFiscaleException("Wrong length CF");
		}

		if (!this.isValid(codiceFiscale.toString(), CaratteriValidi)) {
			throw new GeneratoreCodiceFiscaleException("Wrong chracter in CF");
		}

		return codiceFiscale.toString();

	}

	private String getGiornoNascita() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(this.DataDiNascita);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		int giorno = day;

		if (this.Sesso.equals("F")) {
			giorno = giorno + 40;
		}

		return new DecimalFormat("00").format(giorno);

	}

	private String getMeseNascita() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.DataDiNascita);
		int month = cal.get(Calendar.MONTH);

		return MESI[(++month)];
	}

	private String getAnnoNascita() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.DataDiNascita);
		int year = cal.get(Calendar.YEAR);
		return new DecimalFormat("0000").format(year).substring(2);
	}

	private String ElaboraCognome() {

		StringBuffer consonantiCognome = new StringBuffer(this.getConsonanti(this.Cognome));

		StringBuffer vocaliCognome = new StringBuffer(this.getVocali(this.Cognome));
		StringBuffer caratteriCognome = new StringBuffer();

		caratteriCognome.append(consonantiCognome);
		caratteriCognome.append(vocaliCognome);
		caratteriCognome.append("XXX");

		return caratteriCognome.toString().substring(0, 3);

	}

	private String ElaboraNome() {

		StringBuffer consonantiNome = new StringBuffer(this.getConsonanti(this.Nome));
		StringBuffer vocaliNome = new StringBuffer(this.getVocali(this.Nome));
		StringBuffer caratteriNome = new StringBuffer();

		if (consonantiNome.length() >= 4) {
			caratteriNome.append(consonantiNome.toString().substring(0, 1) + consonantiNome.toString().substring(2, 3)
					+ consonantiNome.toString().substring(3, 4));
		} else {
			caratteriNome.append(consonantiNome);
		}

		caratteriNome.append(vocaliNome);
		caratteriNome.append("XXX");

		return caratteriNome.toString().substring(0, 3);

	}

	private String getConsonanti(String arg) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arg.length(); i++) {
			if (IsConsonante(arg.substring(i, (i + 1)))) {
				sb.append(arg.substring(i, (i + 1)));
			}
		}

		return sb.toString();

	}

	private String getVocali(String arg) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arg.length(); i++) {
			if (IsVocale(arg.substring(i, (i + 1)))) {
				sb.append(arg.substring(i, (i + 1)));
			}
		}

		return sb.toString();

	}

	private boolean IsVocale(String lettera) {
		return VOCALI.contains(lettera);
	}

	private boolean IsConsonante(String lettera) {
		return CONSONANTI.contains(lettera);
	}
	
	public boolean formalmenteValido(String cf) {
		
		String regex_codiceFiscale = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";
		return Pattern.matches(regex_codiceFiscale, cf.trim().toUpperCase());
		
	}

	public String getCarattereDiControllo(String codiceFiscale, boolean controlliFormali)
			throws GeneratoreCodiceFiscaleException {

		if (controlliFormali) {
			if (codiceFiscale.length() != 16) {
				throw new GeneratoreCodiceFiscaleException("Wrong length CF");
			}

			if (!this.isValid(codiceFiscale.toString(), CaratteriValidi)) {
				throw new GeneratoreCodiceFiscaleException("Wrong chracter in CF");
			}
		}

		int intero = 0;
		double r = 1;

		for (int i = 0; i < 15; i++) {

			r = (i + 1) % 2;

			if (r > 0) {

				intero += this.Dispari(codiceFiscale.substring(i, (i + 1)));

			} else {

				intero += this.Pari(codiceFiscale.substring(i, (i + 1)));

			}

		}

		return RESTO[(int) intero % 26];

	}

	public static void main(String args[]) throws GeneratoreCodiceFiscaleException, ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2000-06-08";

		String CF = new GeneratoreCodiceFiscale("MURU", "DAVIDE", formatter.parse(dateInString), "M", "H501").Cacola();
		System.out.println(CF);

	}

}
