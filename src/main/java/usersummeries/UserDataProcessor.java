package usersummeries;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class UserDataProcessor
{
    public static void processUsersFromStream(Reader reader) throws IOException
    {
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
        }

        jsonReader.close();
    }
}
