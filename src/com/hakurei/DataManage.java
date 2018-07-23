package com.hakurei;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManage {
    public static JDBCReflection<User> userData;
    public static JDBCReflection<FileList> fileData;
    public static JDBCReflection<MyGroup>  myGroup;
    public static JDBCReflection<GroupFile> groupFile;



    public DataManage()
    {

    }
        public static void  init() {
        userData =new JDBCReflection<>(new User());
        userData.Find();
        fileData= new JDBCReflection<>(new FileList());
        fileData.Find();
        myGroup =new JDBCReflection<>(new MyGroup());
        myGroup.Find();
        groupFile=new JDBCReflection<>(new GroupFile());
        groupFile.Find();

    }
}
