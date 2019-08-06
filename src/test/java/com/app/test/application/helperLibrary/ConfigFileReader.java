/**
 * Created by Barath Kumar S on 2-Aug-2019
 *
 */
package com.app.test.application.helperLibrary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {


    private Properties properties = new Properties();
    //    Mention the folder path of extent report config xml
    public static final String RESOURCE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources";

    /**
     * This constructor is to load the configuration file
     */
        public ConfigFileReader() {
            BufferedReader myReader = null;
            try {
                myReader = new BufferedReader(new FileReader(RESOURCE_PATH + ".\\propertyFiles\\automationpractice.properties"));
                properties = new Properties();
                try {
                    properties.load(myReader);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Exception found - Properties file not found at path : " + RESOURCE_PATH + "\\automationpractice.properties");
            } finally {
                try {
                    if (myReader != null) myReader.close();
                } catch (IOException ignore) {
                }
            }

        }


    /**
     * Method to return the url read from ccnfig property file
     * @returnValue: String - url value
     */
    public String getApplicationUrl() {
        return properties.getProperty("url");

    }

    /**
     * Method to return the browser name read from ccnfig property file
     * @returnValue: String - browser value
     */
    public String getApplicationBrowser() {
        return properties.getProperty("browser");

    }

    /**
     * Method created to return the path of extent report
     * @returnValue: path of the extent report config xml
     */
    public String getExtentReportConfigPath() {
        return RESOURCE_PATH + "\\extent-report-config.xml";

    }
}
