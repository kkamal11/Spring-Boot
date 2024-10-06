package com.kamal.springJDBCEx.repo;

import com.kamal.springJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student st){

        String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
        int numRowAffected = jdbc.update(sql,st.getRollNo(),st.getName(),st.getMarks());
        System.out.println("Rows affected = " + numRowAffected);
    }

    public List<Student> findAll(){
        String sql = "SELECT * FROM STUDENT";

        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student st = new Student();
                st.setRollNo(rs.getInt("rollno"));
                st.setName(rs.getString("name"));
                st.setMarks(rs.getInt("marks"));
                return st;
            }
        };

        List<Student> result = jdbc.query(sql,mapper);
        return result;
    }
}
