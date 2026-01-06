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
public class ClassQueries {
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addClass;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getClassSeats;
    private static PreparedStatement dropClass;
    private static ResultSet resultSet;
    
    public static void addClass(ClassEntry Class)
    {
        connection = DBConnection.getConnection();
        try
        {
            addClass = connection.prepareStatement("insert into Class (semester, courseCode, seats) values (?, ?, ?)");
            addClass.setString(1, Class.getSemester());
            addClass.setString(2, Class.getCourseCode());
            addClass.setInt(3, Class.getSeats());
            addClass.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList< String > getAllCourseCodes(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList< String > allCourseCodeList = new ArrayList<>();
        try
        {
            getAllCourseCodes = connection.prepareStatement("select semester, courseCode, seats from Class where semester = ? order by courseCode");
            getAllCourseCodes.setString(1, semester);
            resultSet = getAllCourseCodes.executeQuery();
            
            while(resultSet.next())
            {
                ClassEntry Class = new ClassEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                allCourseCodeList.add(Class.getCourseCode());
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return allCourseCodeList;
        
    }
    
    public static int getClassSeats(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        int classseats = 0;
        try
        {
            getClassSeats = connection.prepareStatement("select seats from Class where semester = ? and courseCode = ?");
            getClassSeats.setString(1, semester);
            getClassSeats.setString(2, courseCode);
            resultSet = getClassSeats.executeQuery();
            
            if(resultSet.next())
            {
                classseats = resultSet.getInt("seats");
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
        return classseats;
        
    }
    
    public static void dropClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        try
        {
            dropClass = connection.prepareStatement("delete from Class where semester = ? and courseCode = ?");
            dropClass.setString(1, semester);
            dropClass.setString(2, courseCode);
            dropClass.executeUpdate();
            
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
}
