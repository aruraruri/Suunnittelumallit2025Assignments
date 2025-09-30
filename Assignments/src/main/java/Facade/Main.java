package Facade;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Here's a Chuck Norris joke: "+ApiReader.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value"));
        System.out.println("BBD exchange rate (should be about 2): "+ApiReader.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates.BBD"));
    }
}
