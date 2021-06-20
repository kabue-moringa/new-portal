import org.sql2o.*;

import java.util.ArrayList;
import java.util.List;

public class Departments {
    private String dName;
    private String description;
    private int employeeNo;
    private int id;
    public Departments(String dName, String description, int employeeNo){
        this.dName = dName;
        this.description = description;
        this.employeeNo = employeeNo;
    }

    public String getDName() {
        return dName;
    }

    public String getDescription() {
        return description;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }
    public int getId() {
        return id;
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO departments (dName, description, employeeNo) VALUES (:dName, :description, :employeeNo)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("dName", this.dName)
                    .addParameter("description", this.description)
                    .addParameter("employeeNo", this.employeeNo)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Departments> all() {
        String sql = "SELECT * FROM departments";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Departments.class);
        }
    }
    public static Departments find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM departments where id=:id";
            Departments department = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Departments.class);
            return department;
        }
    }
    public List<Users> getUsers() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM users where department=:dName";
            return con.createQuery(sql)
                    .addParameter("dName", this.dName)
                    .executeAndFetch(Users.class);
        }
    }
    public List<Object> getNews() {
        List<Object> allNews = new ArrayList<Object>();

        try(Connection con = DB.sql2o.open()) {
            String sqlGeneral = "SELECT * FROM news where dName=:dName AND type='General';";
            List<GeneralNews> generalNews = con.createQuery(sqlGeneral)
                    .addParameter("dName", this.dName)
                    .executeAndFetch(GeneralNews.class);
            allNews.addAll(generalNews);

            String sqlDept = "SELECT * FROM news news where dName=:dName AND type='Department';";
            List<DepartmentNews> departmentNews = con.createQuery(sqlDept)
                    .addParameter("dName", this.dName)
                    .executeAndFetch(DepartmentNews.class);
            allNews.addAll(departmentNews);
        }

        return allNews;
    }
}
