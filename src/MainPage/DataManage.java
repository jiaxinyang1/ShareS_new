package MainPage;

public class DataManage {
    public static JDBCReflection<User> userData;
    public static JDBCReflection<FileList> fileData;

    public DataManage()
    {

    }
    public static void  init()
    {
        userData =new JDBCReflection<>(new User());
        userData.Find();
        fileData= new JDBCReflection<>(new FileList());
        fileData.Find();

    }
}
