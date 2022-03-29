package datas;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ExercicioQuatro {
	public static void main(String[] args) {
		LocalDate dataInicial = LocalDate.now();
        LocalDate dataFinal = dataInicial.plus(Period.ofDays(15));
        dataFinal = dataFinal.plus(10, ChronoUnit.HOURS);
        System.out.println(dataFinal.getDayOfWeek());
        System.out.println(dataFinal.getDayOfYear());
        
	}
}
