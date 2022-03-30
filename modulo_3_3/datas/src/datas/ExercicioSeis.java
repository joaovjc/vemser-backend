package datas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ExercicioSeis {
	public static void main(String[] args) {

		ZonedDateTime localDateTime = ZonedDateTime.of(LocalDateTime.of(2024, Month.SEPTEMBER, 14, 18, 30), ZoneId.of("Europe/London"));
		
		Duration between = Duration.between(LocalDateTime.now(), localDateTime);
		
		long anos = (int)between.toDaysPart()/365;
		long meses = (int)(between.toDaysPart()%365)/30;
		long dias = (int)(between.toDaysPart()%365)%30;
		
		System.out.println("Anos: "+ anos);
		System.out.println("Meses: "+ meses);
		System.out.println("Dias: "+ dias);
		System.out.println("Horas: "+ between.toHoursPart());
		System.out.println("Minutos: "+ between.toMinutesPart());
		
		
	}
}
