package com.example.appirest;

public class Post {
    private int userId;
    private int id;
    private String tittle;
    private String body;

    public Post(int i,  String sad, String my_task_title){
        this.userId=i;

        this.tittle=sad;
        this.body=my_task_title;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId=userId;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }


    public String getTittle()
    {
        return tittle;
    }

    public void setTittle(String tittle)
    {
        this.tittle=tittle;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body=body;
    }
    @Override
    public String toString() {
        return "Post{" +
                "title='" + tittle + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
