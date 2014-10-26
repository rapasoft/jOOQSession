package sk.erni.codingbeer;

import java.util.Map;

public interface CodingBeer {

    /**
     * Count all cities that are present in the world database.
     * @return number of all cities in the "world"
     */
    public int countAllCities();

    /**
     * @return the name of the single most inhabited city in the World
     *
     */
    public String fetchCityWithMostInhabitants();

    /**
     * @return a Map that has country name as a key and capital city as a value
     */
    public Map<String, String> fetchEuropeanCountriesWithCapitals();

    /**
     * Calculate the sum of all people speaking chines based on the percentage
     * of people speaking chinese per country.
     */
    public int numberOfPeopleSpeakingChinese();

    /**
     * Add a new Person into database.
     */
    void addPerson(String name, Integer age, Integer city);

    /**
     * @return the list of names of people that are the oldest.
     * E.g. more people can have the same maximum age.
     */
    public java.util.List<String> findOldestPeopleNames();

}