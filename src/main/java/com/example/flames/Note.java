package com.example.flames;

public class Note
{
    private String firstName;
    private  String secondName;

    public Note()
    {

    }

    Note(String firstName,String secondName)
    {
        this.firstName=firstName;
        this.secondName=secondName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public  String getSecondName()
    {
        return secondName;
    }
}
