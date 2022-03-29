package datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class ExercicioUm {

	public static void main(String[] args) throws ParseException {
		LocalDate a = LocalDate.now();
		LocalDate b = LocalDate.of(a.getYear(), Month.of(9), 06);
		Period periodo = null;
		if (a.isAfter(b)) {
			b = LocalDate.of(a.getYear() + 1, b.getMonth(), b.getDayOfMonth());
			periodo = Period.between(a, b);
		} else {
			periodo = Period.between(b, a);
		}

		System.out.println(periodo);

	}

}
