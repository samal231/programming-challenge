package de.exxcellent.challenge.data;

import java.util.List;

public interface Data<T> {

  void processRow(List<String> row);

  void saveIfSmallest(String item, T value1, T value2);

  String getItemWithSmallestDifference();

}
