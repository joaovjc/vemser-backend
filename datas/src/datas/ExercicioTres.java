package datas;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class ExercicioTres {
	public static void main(String[] args) {

		
		List<ZoneId> zoneIds = Arrays.asList(ZoneId.of("Asia/Tokyo"), ZoneId.of("America/Sao_Paulo"), 
				ZoneId.of("America/New_York"), ZoneId.of("Australia/NSW"), ZoneId.of("Europe/Moscow"), 
				ZoneId.of("Asia/Dubai"));
		
		zoneIds.forEach(zoneId -> System.out.println(LocalTime.now(zoneId) + " " +zoneId));
	}
}
