package com.nosbielc.estudos.jdk8.livro;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class JodaTimeExamples {

    public static void main(String[] args) {

        LocalDate mesQueVem = LocalDate.now().plusMonths(1);
        System.out.println("mesQueVem :" + mesQueVem);

        LocalDate anoPassado = LocalDate.now().minusYears(1);
        System.out.println(anoPassado);

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);

        LocalTime agoraHora = LocalTime.now();
        System.out.println(agoraHora);

        LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12, 0);
        System.out.println(hojeAoMeioDia);

        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();
        LocalDateTime dataHora = data.atTime(hora);
        System.out.println(dataHora);

        ZonedDateTime dataComHoraETimezone = dataHora.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println(dataComHoraETimezone);

        LocalDateTime semTimeZone = dataComHoraETimezone.toLocalDateTime();
        System.out.println(semTimeZone);

        LocalDate dataDoPassado = LocalDate.now().withYear(1988);
        System.out.println(dataDoPassado.getYear());

        LocalDate hoje = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);
        System.out.println(hoje.isBefore(amanha));
        System.out.println(hoje.isAfter(amanha));
        System.out.println(hoje.isEqual(amanha));

        ZonedDateTime tokyo =
                ZonedDateTime .of(2011, 5, 2, 10, 30, 0, 0,
                        ZoneId.of("Asia/Tokyo"));
        ZonedDateTime saoPaulo =
                ZonedDateTime .of(2011, 5, 2, 10, 30, 0, 0,
                        ZoneId.of("America/Sao_Paulo"));

        System.out.println(tokyo.isEqual(saoPaulo));

        tokyo = tokyo.plusHours(12);

        System.out.println(tokyo.isEqual(saoPaulo));

        System.out.println("Hoje é dia: " + MonthDay.now().getDayOfMonth());

        YearMonth ym = YearMonth.from(hoje);
        System.out.println(ym.getMonth() + " " + ym.getYear());

        System.out.println(LocalDate.of(2014, 12, 25));
        System.out.println(LocalDate.of(2014, Month.DECEMBER, 25));

        System.out.println(Month.DECEMBER.firstMonthOfQuarter());
        System.out.println(Month.DECEMBER.plus(2));
        System.out.println(Month.DECEMBER.minus(1));

        Locale pt = new Locale("pt");

        System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, pt));
        System.out.println(Month.DECEMBER.getDisplayName(TextStyle.SHORT, pt));

        System.out.println(DayOfWeek.from(hoje));
        System.out.println(DayOfWeek.from(hoje).getDisplayName(TextStyle.FULL, pt));
        System.out.println(DayOfWeek.from(hoje).getDisplayName(TextStyle.SHORT, pt));

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        LocalDateTime agora2 = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String resultado = agora2.format(formatador);
        LocalDate agoraEmData = LocalDate.parse(resultado, formatador);

        System.out.println(resultado + " " + agoraEmData);

        //LocalDate.of(2014, Month.FEBRUARY, 30); causa exception -> java.time.DateTimeException: Invalid date 'FEBRUARY 30'

        LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
        System.out.println(ChronoUnit.DAYS.between(outraData, agora));
        System.out.println(ChronoUnit.MONTHS.between(outraData, agora));
        System.out.println(ChronoUnit.YEARS.between(outraData, agora));
        System.out.printf("%s dias, %s meses e %s anos \n",
                ChronoUnit.DAYS.between(outraData, agora),
                ChronoUnit.MONTHS.between(outraData, agora),
                ChronoUnit.YEARS.between(outraData, agora));

        Period periodo = Period.between(outraData, hoje);
        System.out.printf("%s dias, %s meses e %s anos \n", periodo.getDays(), periodo.getMonths(), periodo.getYears());

        LocalDate nascimento = LocalDate.of(1985, Month.JUNE, 26);
        Period tempoVida = Period.between(nascimento, hoje);
        System.out.printf("Tempo de Vida - > %s dias, %s meses e %s anos \n",
                tempoVida.getDays(), tempoVida.getMonths(), tempoVida.getYears());

        LocalDate outraDataFutura = LocalDate.of(2300, Month.JANUARY, 25);
        Period periodoNegativo = Period.between(outraDataFutura, hoje);
        System.out.printf("%s dias, %s meses e %s anos \n",
                periodoNegativo.getDays(), periodoNegativo.getMonths(), periodoNegativo.getYears());

        if (periodoNegativo.isNegative())
            periodoNegativo = periodoNegativo.negated();

        System.out.printf("%s dias, %s meses e %s anos \n",
                periodoNegativo.getDays(), periodoNegativo.getMonths(), periodoNegativo.getYears());

        LocalDateTime daquiAUmahora = LocalDateTime.now().plusHours(1).plusSeconds(43);
        Duration duration = Duration.between(agora, daquiAUmahora);

        if (duration.isNegative())
            duration = duration.negated();

        System.out.printf("%s horas, %s minutos e %s segundos \n",
                duration.toHours(), duration.toMinutes(), duration.getSeconds());

    }
}
