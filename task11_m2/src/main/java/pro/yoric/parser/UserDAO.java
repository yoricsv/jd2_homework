package pro.yoric.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDAO
{
    private UserDAO()
    {
        usersList = new ArrayList<>();
    }

    public static UserDAO getInstance()
    {
        return instance;
    }

    public void addUser(UserBean user)
    {
        usersList.add(user);
    }

    public List<String> getUsersList() {
        return
            usersList
            .stream()
            .map(
                UserBean::getName
            )
            .collect(
                Collectors.toList()
            );
    }

    private        final List<UserBean> usersList;
    private static final UserDAO instance = new UserDAO();
}
