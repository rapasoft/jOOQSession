package sk.erni.codingbeer;

import java.util.Map;

public interface CodingBeer {

    public int countAllCities();

    public String fetchCityWithMostInhabitants();

    public Map<String, String> fetchEuropeanCountriesWithCapitals();

    public int numberOfPeopleSpeakingChinese();

    void addPerson(String name, Integer age, Integer city);

    public java.util.List<String> findOldestPeopleNames();

}