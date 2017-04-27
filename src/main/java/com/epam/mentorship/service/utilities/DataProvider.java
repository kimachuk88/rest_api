package com.epam.mentorship.service.utilities;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Uliana Pizhanska on 27/04/2017.
 */
public class DataProvider {

    private static Logger log = Logger.getLogger("WD");

    @org.testng.annotations.DataProvider(name = "invalidLogin")
    public static Object[][] invalidLogin() {
        return readData("src/main/resources/uri.csv");
    }


    private static Object[][] readData(String path){
        String[][] data = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            List<String[]> list = bufferedReader.lines()
                    .map(line -> line.split(";"))
                    .collect(Collectors.toList());
            data = list.toArray(new String[list.size()][]);

        }
        catch (FileNotFoundException e){
            log.info("Oops, file is not found");
        }
        return data;
    }
}
