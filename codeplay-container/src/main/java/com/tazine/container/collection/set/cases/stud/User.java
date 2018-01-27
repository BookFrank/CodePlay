package com.tazine.container.collection.set.cases.stud;

/**
 * 如何正确重写 equals() 和 hashCode()
 *
 * @author frank
 * @since 1.0.0
 */
public class User {
    private String name;
    private int age;
    private String passport;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return user.name.equals(name) &&
                user.age == age &&
                user.passport.equals(passport);
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + passport.hashCode();
        return result;
    }
}