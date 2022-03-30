package datas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class ExercicioCinco {
	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime
				.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("pt-BR"))));
		System.out.println(localDateTime
				.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US)));
		System.out.println(localDateTime
				.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE)));
		
		
	}
}
