package interfaces;

import classes.Background;
import Exception.BadWeatherException;

public interface Mobile {
    void changeLocation(Background b1) throws BadWeatherException;

    String getLocation();

}
