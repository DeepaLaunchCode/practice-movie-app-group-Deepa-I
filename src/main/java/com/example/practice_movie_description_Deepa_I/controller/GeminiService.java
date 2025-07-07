package com.example.practice_movie_description_Deepa_I.controller;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    private static final String MODEL_NAME = "gemini-2.0-flash-001";

    /**
     * Generates a 1–2 sentence description of the given movie title.
     */
    public String generateDescription(String title) {
        String prompt = "Give me a 1-2 sentence description of the movie titled '" + title + "'";
        return generateResponseFromGemini(prompt, "Description not available.");
    }

    /**
     * Returns 2–3 main star cast members of the given movie title.
     */
    public String generateStarcast(String title) {
        String prompt = "Give me just name of 2-3 main actors for movie'" + title + "'";
//        String prompt = "Give me 2-3 main star cast of the movie '" + title + "'";
        return generateResponseFromGemini(prompt, "Star cast details not available.");
    }

    /**
     * Returns director(s) of the given movie title.
     */
    public String generateDirectors(String title) {
        String prompt = "Give me just  name of the director for the movie '" + title + "'";
        return generateResponseFromGemini(prompt, "Director details not available.");
    }

    /**
     * Shared method to send prompt to Gemini and handle response.
     */
    private String generateResponseFromGemini(String prompt, String fallbackMessage) {
        try {
            Client client = new Client();
            GenerateContentResponse response = client.models.generateContent(MODEL_NAME, prompt, null);
            String result = response.text();
            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.err.println("Error while generating response: " + e.getMessage());
            return fallbackMessage;
        }
    }
}
