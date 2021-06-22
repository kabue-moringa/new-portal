package dao;

import models.Department;
import models.News;

import java.util.Collection;
import java.util.List;

public interface DepartmentDao {

    void add(Department department);

    void addNewsToDepartment(News news , Department department);

    List<Department> getDepartments();

    List<News> getAllNewsByDepartment(int departmentId);

    Department findById(int id);

    void deleteById(int id);
    void clearAll();

    Collection<Object> getAll();

}