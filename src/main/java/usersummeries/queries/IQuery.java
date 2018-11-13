package usersummeries.queries;

import usersummeries.User;

public interface IQuery
{
    void update(User user);

    void evaluate();
}
