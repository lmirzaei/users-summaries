package usersummeries.queries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import usersummeries.ArrayListHelpers;
import usersummeries.User;

public class MedianAge implements IQuery
{
    private List<User> sortedUsersByAge = new ArrayList<>();
    private AgeComparator ageComparator = new AgeComparator();

    @Override
    public void update(User user)
    {
        ArrayListHelpers.insertSorted(sortedUsersByAge, user, ageComparator);
    }

    @Override
    public void evaluate()
    {
        if (sortedUsersByAge.size() != 0)
        {
            User medianAgeUser = sortedUsersByAge.get(sortedUsersByAge.size() / 2);
            System.out.println(String.format("Median age for Users: %d", medianAgeUser.getAge()));
        }
    }

    private class AgeComparator implements Comparator<User>
    {
        @Override
        public int compare(User user1, User user2)
        {
            return Integer.compare(user1.getAge(), user2.getAge());
        }
    }
}
