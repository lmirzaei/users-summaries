package usersummeries.queries;

import java.text.ParseException;

import usersummeries.User;

public class MeanBalance implements IQuery
{
    private int countUsers = 0;
    private double sumBalance = 0;

    @Override
    public void update(User user)
    {
        try
        {
            sumBalance += user.getBalanceAmount();
            countUsers++;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void evaluate()
    {
        if (countUsers != 0)
        {
            double meanBalance = sumBalance / countUsers;
            System.out.println(String.format("Mean Balance Amount: %f", meanBalance));
        }
    }
}
