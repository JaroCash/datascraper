package com.jarek.datascraper.parser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HTTPGetConnector {

    public static String executePost(String targetURL, Map<String, String> requestParams) {

        HttpURLConnection connection = null;

        try {
            URL requestURL = new URL(targetURL);
            connection = (HttpURLConnection) requestURL.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

//            connection.setRequestProperty("Content-Length", Integer.toString(URLParameters.getBytes().length));

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
//
//            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
//            dataOutputStream.writeBytes(URLParameters);
//            dataOutputStream.close();

            StringBuffer paramsBuffer= new StringBuffer();
            StringBuffer requestParam= new StringBuffer();
            requestParam.append(URLEncoder.encode("search"))
                        .append("=")
                        .append("gta");

            requestParam.append("&");
            requestParam.append(URLEncoder.encode("dzial"))
                        .append("=")
                        .append(" ");

            for (Map.Entry<String, String> entry : requestParams.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                paramsBuffer.append(URLEncoder.encode(key))
                            .append("=")
                            .append(value)
                            .append("&");

            }

            System.out.println(requestParam.toString());
            System.out.println(paramsBuffer.toString());

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());
            outputStreamWriter.write(paramsBuffer.toString());
            outputStreamWriter.flush();

            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer response = new StringBuffer();

            String line;

            while((line = bufferedReader.readLine()) !=null){
                response.append(line);
                response.append('\r');
            }

            bufferedReader.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }
}
