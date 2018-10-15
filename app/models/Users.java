package models;

import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import java.util.List;

@Entity
public class Users extends Model {

    @Id
    @Constraints.Min(10)
    public int id;

//    @Constraints.Required
    public String first_name;
    public String last_name;


//    public boolean done;

//    @Formats.DateTime(pattern="dd/MM/yyyy")
//    public Date dueDate = new Date();

    public static final Finder<String, Users> find = new Finder<>(Users.class);

    public Users() {
    }

    public Users(int id, String first_name, String last_name ) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    // Find all Users
    public static List<Users> findAll() {
        return Users.find.all();
    }

    // Find a Users by id
    public static Users findbyId(String id) {
        return Users.find.byId(id);
    }

    public static void deletebyId(String id) {
        Users.find.deleteById(id);
    }

    public static List<Users> findQeury() {
        List<Users> complexUsers = Users.find.query().where()
                .ilike("first_name", "%ey%")
                .orderBy("date_created asc")
                .setFirstRow(0)
                .setMaxRows(1)
                .findPagedList()
                .getList();
        return complexUsers;
    }
}
