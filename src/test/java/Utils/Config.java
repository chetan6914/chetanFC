package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {

    static public String Env = "";
    static public String Module = "";
    static public String Browser = "";

    Properties ConfigFile;

    public Config() throws IOException {
        if(System.getenv("Env")!=null)
        {
            Env = System.getenv("Env");
            System.out.println("Executing on " +Env+ " Environment");
        }
        if(System.getenv("ProjectName")!=null)
        {
            Module = System.getenv("ProjectName");
        }

        ConfigFile = new Properties();
        if(Env == null)
        {
            File file = new File("src\\test\\resources\\ConfigFile\\"+Module+"\\QAENV.properties");
            ConfigFile.load(new FileInputStream(file.getAbsolutePath()));
        }
        if(Env.equalsIgnoreCase("QA"))
        {
            File file = new File("src\\test\\resources\\ConfigFile\\"+Module+"\\QAENV.properties");
            ConfigFile.load(new FileInputStream(file.getAbsolutePath()));
        }
        if(Env.equalsIgnoreCase("Stage"))
        {
            File file = new File("src\\test\\resources\\ConfigFile\\"+Module+"\\STAGEENV.properties");
            ConfigFile.load(new FileInputStream(file.getAbsolutePath()));
        }
        if(Env.equalsIgnoreCase("Prod"))
        {
            File file = new File("src\\test\\resources\\ConfigFile\\"+Module+"\\PRODENV.properties");
            ConfigFile.load(new FileInputStream(file.getAbsolutePath()));
        }

    }

    public String getProperty(String key)
    {
        String value = this.ConfigFile.getProperty(key);
        return value;
    }


}
