package de.exxcellent.challenge.data;

import java.util.List;

public class WeatherData implements Data<Double> {

  private boolean firstRow = true;
  private String day;
  // Set to a high number so it gets changed in the first iteration
  private double smallestDifference = 1000;

  private String column1;
  private String column2;

  private int column1Index;
  private int column2Index;

  public WeatherData(String column1, String column2) {
    this.column1 = column1;
    this.column2 = column2;
  }

  @Override
  public void processRow(List<String> row) {
    if(firstRow) {
      column1Index = row.indexOf(column1);
      column2Index = row.indexOf(column2);
      firstRow = false;
    } else {
      saveIfSmallest(row.get(0), Double.parseDouble(row.get(column1Index)), Double.parseDouble(row.get(column2Index)));
    }
  }

  @Override
  public void saveIfSmallest(String day, Double value1, Double value2) {
    double difference = value1 - value2;
    if(difference < smallestDifference) {
      smallestDifference = difference;
      this.day = day;
    }
  }

  @Override
  public String getItemWithSmallestDifference() {
    return day;
  }
}
