package usersummeries.queries;

import usersummeries.Gender;
import usersummeries.User;

public class MeanUnreadMessages implements IQuery
{
    private int countFemaleUsers = 0;
    private int countUnreadMessages = 0;

    @Override
    public void update(User user)
    {
        if (user.getGender() == Gender.female && user.isActive())
        {
            countFemaleUsers++;
            countUnreadMessages += user.getUnreadMessages();
        }
    }

    @Override
    public void evaluate()
    {
        if (countFemaleUsers != 0)
        {
            double meanUnreadMessages = countUnreadMessages * 1f / countFemaleUsers;
            System.out.println(String.format("Mean for number of Unread messages for Active females: %f", meanUnreadMessages));
        }
    }
}
