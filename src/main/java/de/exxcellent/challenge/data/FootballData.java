package de.exxcellent.challenge.data;

import java.util.List;

public class FootballData implements Data<Integer> {

  private boolean firstRow = true;
  private String team;
  // Set to a high number so it gets changed in the first iteration
  private int smallestDifference = 1000;

  private String column1;
  private String column2;

  private int column1Index;
  private int column2Index;

  public FootballData(String column1, String column2) {
    this.column1 = column1;
    this.column2 = column2;
  }

  @Override
  public void processRow(List<String> row) {
    if(firstRow) {
      column1Index = row.indexOf(column1);
      column2Index = row.indexOf(column2);
      firstRow = false;
      return;
    }
    saveIfSmallest(row.get(0), Integer.parseInt(row.get(column1Index)), Integer.parseInt(row.get(column2Index)));
  }

  @Override
  public void saveIfSmallest(String team, Integer value1, Integer value2) {
    int difference = value1 - value2;
    if(difference < smallestDifference) {
      smallestDifference = difference;
      this.team = team;
    }
  }

  @Override
  public String getItemWithSmallestDifference() {
    return team;
  }

}
