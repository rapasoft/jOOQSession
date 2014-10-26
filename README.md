jOOQSession
===========

Coding beer session for quick introduction in jOOQ.

# Preconditions
- good knowledge of SQL
- MySQL database installed (Or you can use http://www.db4free.net/signup.php)

## Setup connection to the database in pom.xml:

```
    <properties>
        <database.driver>com.mysql.jdbc.Driver</database.driver>
        <database.url>jdbc:mysql://localhost:3306/test?useUnicode=yes&amp;characterEncoding=utf8</database.url>
        <database.username>root</database.username>
        <database.password/>
    </properties>
```

## Load the world_innodb.sql script into your database

# Code generation
(more info: http://www.jooq.org/doc/3.4/manual/code-generation/codegen-configuration/)
You can use jOOQ to generate classes out of database structure that can be used for typesafe queries or easy CRUD operations.
This can be set up easily using maven plugin. The code generation is run together with the `package` goal.

# Assignment
Implement methods in the `CodingBeer` interface so that all the tests are passed without problems.

```
public interface CodingBeer {

    public int countAllCities();

    public String fetchCityWithMostInhabitants();

    public Map<String, String> fetchEuropeanCountriesWithCapitals();

    public int numberOfPeopleSpeakingChinese();

    void addPerson(String name, Integer age, Integer city);

    public java.util.List<String> findOldestPeopleNames();

}
```
