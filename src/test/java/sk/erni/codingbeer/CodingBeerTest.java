package sk.erni.codingbeer;

import org.junit.Before;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CodingBeerTest {

    CodingBeer codingBeer;

    @Before
    public void init() {
        //Make an instance of the coding beer implementation here
        // codingBeer = new CodingBeerImpl();
        assertNotNull(codingBeer);
    }

    @org.junit.Test
    public void testCountAllCities() throws Exception {
        int numberOfCitiesInWorld = 4079;
        assertEquals(numberOfCitiesInWorld, codingBeer.countAllCities());
    }

    @org.junit.Test
    public void testFetchCityWithMostInhabitants() throws Exception {
        String mostPopulatedCity = "Mumbai (Bombay)";
        assertEquals(mostPopulatedCity, codingBeer.fetchCityWithMostInhabitants());
    }

    @org.junit.Test
    public void testFetchEuropeanCountriesWithCapitals() throws Exception {
        Map<String, String> countryToCityMap = new TreeMap<>();
        String expectedResultString = "Albania=Tirana, Andorra=Andorra la Vella, Austria=Wien, Belgium=Bruxelles [Brussel], Bulgaria=Sofija, Bosnia and Herzegovina=Sarajevo, Belarus=Minsk, Switzerland=Bern, Czech Republic=Praha, Germany=Berlin, Denmark=K?benhavn, Spain=Madrid, Estonia=Tallinn, Finland=Helsinki [Helsingfors], France=Paris, Faroe Islands=Tórshavn, United Kingdom=London, Gibraltar=Gibraltar, Greece=Athenai, Croatia=Zagreb, Hungary=Budapest, Ireland=Dublin, Iceland=Reykjavík, Italy=Roma, Liechtenstein=Vaduz, Lithuania=Vilnius, Luxembourg=Luxembourg [Luxemburg/Lëtzebuerg], Latvia=Riga, Monaco=Monaco-Ville, Moldova=Chisinau, Macedonia=Skopje, Malta=Valletta, Netherlands=Amsterdam, Norway=Oslo, Poland=Warszawa, Portugal=Lisboa, Romania=Bucuresti, Russian Federation=Moscow, Svalbard and Jan Mayen=Longyearbyen, San Marino=San Marino, Slovakia=Bratislava, Slovenia=Ljubljana, Sweden=Stockholm, Ukraine=Kyiv, Holy See (Vatican City State)=Citt? del Vaticano, Yugoslavia=Beograd";
        Arrays.asList(expectedResultString.split(",")).forEach(r -> {
            List<String> pair = Arrays.asList(r.trim().split("="));
            countryToCityMap.put(pair.get(0), pair.get(1));
        });
        assertEquals(countryToCityMap, codingBeer.fetchEuropeanCountriesWithCapitals());
    }

    @org.junit.Test
    public void testNumberOfPeopleSpeakingChinese() throws Exception {
        int numberOfChineseSpeakingPeople = 1191843539;
        assertEquals(numberOfChineseSpeakingPeople, codingBeer.numberOfPeopleSpeakingChinese());
    }

    @org.junit.Test
    public void testFetchOldestPersonName() throws Exception {
        codingBeer.addPerson("Jano", 25, 123);
        codingBeer.addPerson("Fero", 26, 124);
        codingBeer.addPerson("Jozo", 27, 125);
        codingBeer.addPerson("Laco", 28, 126);

        assertEquals("Laco", codingBeer.findOldestPeopleNames().get(0));

        codingBeer.deleteAllPersons();
    }
}