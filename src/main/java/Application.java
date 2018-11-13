import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import usersummeries.UserDataProcessor;
import usersummeries.queries.GroupByYear;
import usersummeries.queries.IQuery;
import usersummeries.queries.MeanBalance;
import usersummeries.queries.MeanUnreadMessages;
import usersummeries.queries.MedianAge;
import usersummeries.queries.MedianFriends;

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

            List<IQuery> queries = Arrays.asList(
                    new GroupByYear(),
                    new MedianFriends(),
                    new MedianAge(),
                    new MeanBalance(),
                    new MeanUnreadMessages());

            UserDataProcessor.processUsersFromStream(fileReader, queries);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
