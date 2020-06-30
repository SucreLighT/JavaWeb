package cn.sucre.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author sucre
 * @date 2020-06-30
 * @time 15:06
 * @description
 */
public class User {
    private String name;
    private int age;
    private Date birthday;


    /**
     * 该方法没有对应的成员变量，只是为了美化显示而设计，称之为逻辑视图（设计视图）
     * @return
     */
    public String getBirStr(){
        if(birthday != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(birthday);

        }else {
            return "";
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
