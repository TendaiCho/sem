package com.napier.sem;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Country {

    public String code;
    public String name;
    public String continent;
    public String region;
    public int population;


    public ArrayList<Country> getCountriesPopulations()
    {
        try {
            Statement stat = conn.createStatement();
            String strSelect =
                    "Select code,name,continent,region,population from country order by population desc";
            ResultSet rset = stat.executeQuery(strSelect);
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("countries.code");
                country.name = rset.getString("countries.name");
                country.continent = rset.getString("countries.continent");
                country.region = rset.getString("countries.region");
                country.population = rset.getInt("countries.population");
                countries.add(country);
            }
            return countries;
        }
        catch(exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get countries details");
                return null;
            }

    }
    public void printPopulation(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Code", "Name", "Continent","Region", "Population"));
        // Loop over all employees in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-10s %-15s %-20s %-8s",
                         country.code,country.name,country.continent,country.region,country.population);
            System.out.println(emp_string);
        }
    }

}
