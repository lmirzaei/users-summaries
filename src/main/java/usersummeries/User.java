package usersummeries;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class User
{
    private String guid;
    private boolean isActive;
    private String balance;
    private Double balanceAmount = Double.MIN_VALUE;
    private int age;
    private String eyeColor;
    private String name;
    private Gender gender;
    private String email;
    private String phone;
    private String address;
    private Date registered;
    private List<Friend> friends;
    private String greeting;
    private String favoriteFruit;

    public User()
    {

    }

    public String getGuid()
    {
        return guid;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public String getBalance()
    {
        return balance;
    }

    public double getBalanceAmount() throws ParseException
    {
        if (balanceAmount == Double.MIN_VALUE)
        {
            balanceAmount = parseBalance(balance);
        }

        return balanceAmount;
    }

    private Double parseBalance(String balance) throws ParseException
    {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        Number number = numberFormat.parse(balance);
        return number.doubleValue();
    }

    public int getAge()
    {
        return age;
    }

    public String getEyeColor()
    {
        return eyeColor;
    }

    public String getName()
    {
        return name;
    }

    public Gender getGender()
    {
        return gender;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getAddress()
    {
        return address;
    }

    public Date getRegistered()
    {
        return registered;
    }

    public List<Friend> getFriends()
    {
        return friends;
    }

    public String getGreeting()
    {
        return greeting;
    }

    public String getFavoriteFruit()
    {
        return favoriteFruit;
    }

    public class Friend
    {
        private String name;

        public Friend()
        {

        }

        public String getName()
        {
            return name;
        }
    }
}
