package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

import de.exxcellent.challenge.data.Data;
import de.exxcellent.challenge.data.WeatherData;

public final class SmallestDifferenceFinder {

  public static void main(String... args) {
    Data weatherData = new WeatherData("MxT", "MnT");
    processFile(weatherData, getFileURL("de/exxcellent/challenge/weather.csv"));
    System.out.printf("Day with smallest temperature spread : %s%n", weatherData.getItemWithSmallestDifference());
  }

  private static URL getFileURL(String fileName) {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    URL fileURL = classLoader.getResource(fileName);
    if(fileURL == null) {
      System.out.printf("File: %s not found", fileName);
      System.exit(1);
    }
    return fileURL;
  }

  private static void processFile(Data weatherData, URL url) {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      String line;
      while((line = reader.readLine()) != null) {
        weatherData.processRow(Arrays.asList(line.split(",")));
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

}
