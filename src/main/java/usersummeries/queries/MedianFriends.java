package usersummeries.queries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import usersummeries.ArrayListHelpers;
import usersummeries.User;

public class MedianFriends implements IQuery
{
    private List<User> sortedUsersByFriendsCount = new ArrayList<>();
    private FriendsCountComparator friendsCountComparator = new FriendsCountComparator();

    @Override
    public void update(User user)
    {
        ArrayListHelpers.insertSorted(sortedUsersByFriendsCount, user, friendsCountComparator);
    }

    @Override
    public void evaluate()
    {
        if (sortedUsersByFriendsCount.size() != 0)
        {
            User medianFriendsCountUser = sortedUsersByFriendsCount.get(sortedUsersByFriendsCount.size() / 2);
            System.out.println(String.format("Median for Number of Friends: %d", medianFriendsCountUser.getFriends().size()));
        }
    }

    private class FriendsCountComparator implements Comparator<User>
    {
        @Override
        public int compare(User user1, User user2)
        {
            return Integer.compare(user1.getFriends().size(), user2.getFriends().size());
        }
    }
}
