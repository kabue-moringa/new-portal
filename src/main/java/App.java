import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeeDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import models.Department;
import models.Employee;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        Sql2oDepartmentDao departmentDao;
        Sql2oEmployeeDao employeeDao;
        Sql2oNewsDao newsDao;
        Connection connection;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Access");

        employeeDao = new Sql2oEmployeeDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o) {
            @Override
            public Collection<Object> getAll() {
                return null;
            }
        };
        connection= sql2o.open();


        get("/departments", "application/json", (request, response) -> {
            return gson.toJson(departmentDao.getDepartments());
        });
        get("/departments", "application/json", (request, response) -> {
            return gson.toJson(departmentDao.getDepartments());

        });


        get("departments/:id", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null) {
                throw new ApiException(404, String.format("No department with the id:\"%s\" exists", request.queryParams("id")));
            }
            return gson.toJson(departmentToFind);
        });


        get ("/employees", "application/json", (request, response) -> {
            return  gson.toJson(employeeDao.getEmployees());
        });
        get("/employees/:id", "application/json", (request, response) -> {
            response.type("/application/json");
            int employeeId = Integer.parseInt(request.params("id"));
            return gson.toJson(departmentDao.findById(employeeId));
        });


        get("/news", "application/json", (request, response) -> {
            return gson.toJson(newsDao.getNews());
        });
        get("/news/:id", "application/json", (request, response) -> {
            int newsId = Integer.parseInt(request.params("id"));
            return gson.toJson(newsDao.findById(newsId));
        });

        post("/departments/new", "application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });
        post("/employees/new", "application/json", (request, response) -> {
            Employee employee = gson.fromJson(request.body(), Employee.class);
            employeeDao.add(employee);
            response.status(201);
            return gson.toJson(employee);
        });
        post("/news/new", "application/json",(request, response) -> {
            News news = gson.fromJson(request.body(),News.class);
            newsDao.add(news);
            response.status(201);
            return  gson.toJson(news);
        });

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) -> {
            res.type("application/json");
        });


    }
}
