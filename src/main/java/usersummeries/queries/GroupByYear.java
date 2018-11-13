package usersummeries.queries;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

import usersummeries.User;

public class GroupByYear implements IQuery
{
    private Hashtable<Integer, List<User>> usersGroupByYear = new Hashtable<>();

    @Override
    public void update(User user)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(user.getRegistered());
        int registeredYear = calendar.get(Calendar.YEAR);

        if (usersGroupByYear.containsKey(registeredYear))
        {
            usersGroupByYear.get(registeredYear).add(user);
        }

        else
        {
            List<User> aNewYearUsers = new ArrayList<>();
            aNewYearUsers.add(user);
            usersGroupByYear.put(registeredYear, aNewYearUsers);
        }
    }

    @Override
    public void evaluate()
    {
        for (Integer year : usersGroupByYear.keySet())
        {
            System.out.println("---------Year: " + year + " ---------");
            for (User user : usersGroupByYear.get(year))
            {
                System.out.println(user.toString());
            }
        }
    }
}
