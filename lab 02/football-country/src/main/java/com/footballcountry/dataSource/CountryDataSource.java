package com.footballcountry.dataSource;

import com.footballcountry.model.countrydata.Country;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryDataSource {
    public DataSource<Country[]> getCountriesDataSource() {
        return new DataSource<>();
    }
}
