import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import usersummeries.UserDataProcessor;

public class Application
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.err.println("Must pass a single argument with path to JSON data file.");
            return;
        }

        try
        {
            FileInputStream fileStream = new FileInputStream(args[0]);
            Reader fileReader = new InputStreamReader(fileStream);
            UserDataProcessor.processUsersFromStream(fileReader);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
