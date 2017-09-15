package utility;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyProvider {

    private static PropertyProvider instance = null;
    private static Properties properties = new Properties();
    private String propPath = ".\\src\\main\\resources\\gmail.properties";

    private PropertyProvider() {
        propPath = FilenameUtils.separatorsToSystem(new File("").getAbsolutePath() + "\\" + propPath);
        loadProperties(propPath);
    }

    private void loadProperties(String fileName) {
        File localFile = new File(fileName);
        if (!localFile.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(localFile.getAbsolutePath());
                properties.load(fis);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Exception's happened trying to load props from: " + fileName);
            }
        }
    }

    public static String getProperty(String propertyName) {
        if (instance == null) instance = new PropertyProvider();
        //instance = instance != null ? instance : new PropertyProvider();
        String propertyValue;
        if ((System.getProperty(propertyName) != null)) {
            propertyValue = System.getProperty(propertyName);
        } else
            propertyValue = PropertyProvider.properties.getProperty(propertyName);
        return propertyValue;
    }
}
