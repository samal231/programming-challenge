package de.exxcellent.challenge.data;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherDataTest {

  private WeatherData weatherData;

  private List<String> rowTwo;

  @Before
  public void setUp() throws Exception {
    weatherData = new WeatherData("MxT", "MnT");
    List<String> headerRow = Arrays.asList("Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP".split(","));
    List<String> rowOne = Arrays.asList("1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5".split(","));
    rowTwo = Arrays.asList("2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5".split(","));

    weatherData.processRow(headerRow);
    weatherData.processRow(rowOne);
  }

  @Test
  public void processOneRow() throws Exception {
    assertEquals("1", weatherData.getItemWithSmallestDifference());
  }

  @Test
  public void processTwoRows() throws Exception {
    weatherData.processRow(rowTwo);
    assertEquals("2", weatherData.getItemWithSmallestDifference());
  }

  @Test
  public void saveIfSmallest() throws Exception {
    weatherData.saveIfSmallest("100", 88.0, 80.0);
    assertEquals("100", weatherData.getItemWithSmallestDifference());
  }

}