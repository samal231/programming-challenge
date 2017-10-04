package de.exxcellent.challenge.data;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballDataTest {

  private FootballData footballData;

  private List<String> rowTwo;

  @Before
  public void setUp() throws Exception {
    footballData = new FootballData("Goals", "Goals Allowed");
    List<String> headerRow = Arrays.asList("Team,Games,Wins,Losses,Draws,Goals,Goals Allowed,Points".split(","));
    List<String> rowOne = Arrays.asList("Arsenal,38,26,9,3,79,36,87".split(","));
    rowTwo = Arrays.asList("Liverpool,38,24,8,6,67,30,80".split(","));

    footballData.processRow(headerRow);
    footballData.processRow(rowOne);

  }

  @Test
  public void processOneRow() throws Exception {
    assertEquals("Arsenal", footballData.getItemWithSmallestDifference());
  }

  @Test
  public void processTwoRows() throws Exception {
    footballData.processRow(rowTwo);
    assertEquals("Liverpool", footballData.getItemWithSmallestDifference());
  }

  @Test
  public void saveIfSmallest() throws Exception {
    footballData.saveIfSmallest("Bayern Munich", 88, 80);
    assertEquals("Bayern Munich", footballData.getItemWithSmallestDifference());
  }

}