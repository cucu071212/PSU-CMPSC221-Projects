/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author wonjonghun
 */
public class MultiTableQueries {
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement getAllClassDescriptions;
    private static PreparedStatement getScheduledStudentsByClass;
    private static PreparedStatement getWaitlistedStudentsByClass;
    private static ResultSet resultSet;
    
    
    public static ArrayList<ClassDescription> getAllClassDescriptions(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<ClassDescription> allClassDescriptions = new ArrayList<>();
        try
        {
            getAllClassDescriptions = connection.prepareStatement("select Class.courseCode, description, seats from Class, course where semester = ? and Class.courseCode = course.courseCode order by Class.courseCode");
            getAllClassDescriptions.setString(1, semester);
            resultSet = getAllClassDescriptions.executeQuery();
            
            while(resultSet.next())
            {
                ClassDescription description = new ClassDescription(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                allClassDescriptions.add(description);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return allClassDescriptions;
        
    }
    
    public static ArrayList<StudentEntry> getScheduledStudentsByClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> scheduledStudent = new ArrayList<>();
        try
        {
            getScheduledStudentsByClass = connection.prepareStatement("select semester, coursecode, studentID, status, timestamp from schedule where semester = ? and courseCode = ? and status = 'scheduled' order by timestamp");
            getScheduledStudentsByClass.setString(1, semester);
            getScheduledStudentsByClass.setString(2, courseCode);
            resultSet = getScheduledStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                StudentEntry student = StudentQueries.getStudent(resultSet.getString(3));
                scheduledStudent.add(student);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return scheduledStudent;
        
    }
    
    public static ArrayList<StudentEntry> getWaitlistedStudentsByClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> waitlistedStudent = new ArrayList<>();
        try
        {
            getWaitlistedStudentsByClass = connection.prepareStatement("select semester, coursecode, studentID, status, timestamp from schedule where semester = ? and courseCode = ? and status = 'waitlisted' order by timestamp");
            getWaitlistedStudentsByClass.setString(1, semester);
            getWaitlistedStudentsByClass.setString(2, courseCode);
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                StudentEntry student = StudentQueries.getStudent(resultSet.getString(3));
                waitlistedStudent.add(student);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return waitlistedStudent;
        
    }
    
    
    
    
}

