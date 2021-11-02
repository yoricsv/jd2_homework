package pro.yoric.registration.data;

public class UserBean
{
    private String userName;
    private String userSurname;
    private String userPhone;
    private String userEmail;

    public UserBean(){ }

    public UserBean(
            String name,
            String surname,
            String phone,
            String email
        )
    {
        this.userName    = name;
        this.userSurname = surname;
        this.userPhone   = phone;
        this.userEmail   = email;
    }

    public String getName()
    {
        return userName;
    }
    public String getSurname()
    {
        return userSurname;
    }
    public String getPhone()
    {
        return userPhone;
    }
    public String getEmail()
    {
        return userEmail;
    }

    public void setName (String name)
    {
        this.userName = name;
    }
    public void setSurname (String surname)
    {
        this.userSurname = surname;
    }
    public void setPhone (String phone)
    {
        this.userPhone = phone;
    }
    public void setEmail (String email)
    {
        this.userEmail = email;
    }

    @Override
    public String toString()
    {
        return  "User {"            +
                    "Name = '"      + userName      + "'\', "   +
                    "Surname = '"   + userSurname   + "'\''"    +
                    "Phone = '"     + userPhone     + "'\', "   +
                    "E-mail = '"    + userEmail     + "'\''"    +
                "}";
    }

//    @Override
//    public boolean equals (Object beanObj)
//    {
//        if (this == beanObj)
//            return true;
//
//        if (   beanObj    == null
//                || getClass() != beanObj.getClass()
//        )
//            return false;
//
//        UserBean user = (UserBean) beanObj;
//
//        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
//
//        return password != null ? password.equals(user.password) : user.password == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = userName != null ? userName.hashCode() : 0;
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        return result;
//    }
}
