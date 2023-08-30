package org.example.functions;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyMessage {

    public static void main(String[] args) throws IOException {
        String todaysMessage = new DailyMessage().getTodaysMessage();
        System.out.println(todaysMessage);
        new TwilioSMSSender().sendMessage(todaysMessage);
    }

    public String getTodaysMessage() throws IOException {
        LocalDate today = LocalDate.now(Config.MY_TIMEZONE);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd");
        String todaysDate = today.format(dateFormatter);

        Wttr.WttrResult wttr = new Wttr().getTodaysWeather();

        String affirmation = new Affirmation().getAffirmation();
        String quote = new QuoteGenerator().getQuote();

        return String.format(
                "Good Morning! %s🌡%s\n" +
                        "It's %s %s\n" +
                        "%s\n" +
                        "%s\n " +
                        "✨ Have a Great Day ✨",
                wttr.weather, wttr.temperature,
                todaysDate, wttr.moonPhase,
                affirmation,
                quote
        );
    }
}
