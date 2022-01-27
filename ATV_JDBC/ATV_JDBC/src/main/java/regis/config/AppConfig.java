/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regis.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author daypn
 */
public class AppConfig {

    public static Properties PROPS = null;

    static {
        try {
            Properties props = new Properties();
            InputStream is = AppConfig.class.getResourceAsStream("/config.properties");
            System.out.println(is);
            props.load(is);
            PROPS = props;
            System.out.println(PROPS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

