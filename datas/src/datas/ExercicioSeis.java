package datas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class ExercicioSeis {
	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.of(2024, Month.SEPTEMBER, 14, 0, 0);
		
		Duration between = Duration.between(LocalDateTime.now(), localDateTime);
		
		System.out.printf(" %d:%02d:%02d", 
				between.toHours(), 
				between.toMinutesPart(), 
				between.toSecondsPart());
		
	}
}
