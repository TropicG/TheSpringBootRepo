package com.tropic.repository;

import com.tropic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("StudentRepo")
@Scope("singleton")
public class StudentRepo {


    // Spring will take care of the initializing and creating this istance
    // Behind the scenes, it will use DataSource and instantiate the jdbc variable
    @Autowired
    // this data-member is gonna take care of the connection with the database instead of us and will execute the sql query we give to him
    // as well ass performs the proper mapping between the obejct's data members and table's collums
    private JdbcTemplate jdbc;

    public void saveStudent(Student student) {
        // When using JDBC we have two options: execute query OR execute update
        // When updating data like inserting, updating or removing we use execute update
        // When want to fire a select query we use execute query

        // this SQL query will be passed for execution, and the ? are gonna be replaced with the object's data
        String SQL = "insert into student (rollno, name, marks) values (?,?,?)";
        jdbc.update(SQL, student.getRollno(), student.getName(), student.getMarks());
    }

    public List<Student> findAll() {

        String sql = "select * from student";

        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setRollno(rs.getInt("rollno"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));

                return student;
            }
        };

        return jdbc.query(sql, mapper);
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
