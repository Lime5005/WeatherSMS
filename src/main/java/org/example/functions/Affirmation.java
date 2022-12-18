package org.example.functions;

import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URI;

public class Affirmation {
    public String getAffirmation() throws IOException {

        String affirmationJson = Request
                .Get(URI.create("https://www.affirmations.dev"))
                .execute()
                .returnContent()
                .asString();

        String affirmationText = Config.MAPPER
                .readTree(affirmationJson)
                .get("affirmation")
                .asText();

        return String.format("🤔 Remember: %s 👍", affirmationText);
    }
}
