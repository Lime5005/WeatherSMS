package org.example.functions;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URI;

public class QuoteGenerator {

    public String getQuote() throws IOException {

        String quoteJson = Request
                .Get(URI.create("https://api.forismatic.com/api/1.0/?method=getQuote&lang=en&format=json"))
                .execute()
                .returnContent()
                .asString();

        String quoteText = Config.MAPPER
                .readTree(quoteJson)
                .get("quoteText")
                .asText();

        String quoteAuthor = Config.MAPPER
                .readTree(quoteJson)
                .get("quoteAuthor")
                .asText();

        return String.format("Today's Quote: %s \n-%s", quoteText, quoteAuthor);
    }
}
