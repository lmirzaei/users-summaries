package usersummeries;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import usersummeries.queries.GroupByYear;
import usersummeries.queries.IQuery;
import usersummeries.queries.MedianFriends;

public class UserDataProcessor
{
    private final static int SUMMARY_INTERVAL = 1000;

    public static void processUsersFromStream(Reader reader) throws IOException
    {
        List<IQuery> queries = Arrays.asList(
                new GroupByYear(),
                new MedianFriends());

        List<User> users = new ArrayList<>();
        JsonReader jsonReader = new JsonReader(reader);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-mm-dd'T'HH:mm:ss' 'XXX")
                .create();

        jsonReader.beginArray();
        while (jsonReader.hasNext())
        {
            User aUser = gson.fromJson(jsonReader, User.class);
            users.add(aUser);
            for (IQuery query : queries)
            {
                query.update(aUser);
            }

            // Per requirement print updated queries every 1000 items
            if (users.size() % SUMMARY_INTERVAL == 0)
            {
                for (IQuery query : queries)
                {
                    query.evaluate();
                }
            }
        }

        if (users.size() % SUMMARY_INTERVAL != 0)
        {
            // Run queries including remaining users
            for (IQuery query : queries)
            {
                query.evaluate();
            }
        }

        jsonReader.close();
    }
}
