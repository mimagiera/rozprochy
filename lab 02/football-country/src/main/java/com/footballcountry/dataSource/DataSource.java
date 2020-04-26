package com.footballcountry.dataSource;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static java.lang.String.format;

public class DataSource<T> {

    private static String TOKEN = "token here";
    Logger logger = LoggerFactory.getLogger(DataSource.class);

    public Optional<T> getObjectFromJson(String urlTarget, Class<T> myClass) {
        Gson gson = new Gson();
        String json;
        T result;

        try {
            json = getJsonStringByUrl(urlTarget);
            result = gson.fromJson(json, myClass);
            return Optional.of(result);
        } catch (Exception e) {
            logger.error(format("Url: %s, error message: %s", urlTarget, e.getMessage()));
            return Optional.empty();
        }

    }

    private static String getJsonStringByUrl(final String urlTarget) throws Exception {
        URL url = new URL(urlTarget);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        http.setRequestMethod("GET");
        http.setRequestProperty("X-Auth-Token", TOKEN);
        http.setUseCaches(false);
        http.setAllowUserInteraction(false);
        http.connect();

        int status = http.getResponseCode();
        if (status == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            br.close();
            return sb.toString();

        } else {
            throw new Exception("Status " + status);
        }
    }
}
