package com.hakurei;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCReflection<T> {

    private String dataBaseName ="shareSpace";//默认名称
    JDBC jdbc =new JDBC(dataBaseName);
    private List<T> list =new ArrayList<>();


    public List<T> getList() {//list
        return list;
    }
    private String className;//类名
    private Class aClass;//类
    private List<String> values= new ArrayList<>();//要添加的数据值转换为sql语句
    private List<String> field= new ArrayList<>();//字段名称
    private Field[] fields;//字段

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public JDBCReflection(T object)
    {
        jdbc.init();
        aClass=object.getClass();
        className=object.getClass().getSimpleName();
        fields =object.getClass().getDeclaredFields();
        for (int i=0;i<fields.length;i++)
        {
            field.add(fields[i].getName());//获取字段名称
        }
    }

    private void dataToString(T data)
    {

        String methodName;
        for (int i=0;i<fields.length;i++)
        {

            String buffer="\'";
            methodName=fields[i].getName().substring(0,1).toUpperCase()+fields[i].getName().substring(1);
            methodName="get"+methodName;
            try {
                buffer+=data.getClass().getMethod(methodName,null).invoke(data).toString();
                buffer+="\'";
                values.add(buffer);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }
    public void Insert(T data)
    {
        if (isReapt(data))
        {
            System.out.print("重复了");
            return;
        }
        list.add(data);
        dataToString(data);
        String sql ="INSERT INTO "+className+" values(";
        for (int i=0;i<values.size()-1;i++)
        {
            sql+=values.get(i)+",";
        }
        sql+=values.get(values.size()-1);
        sql+=")";
        jdbc.update(sql);
    }
    public void Delete(T data){
        if (list.contains(data))
        {
            list.remove(data);
        }
        else throw new NullPointerException();
        String sql="DELETE from "+className+" where ";
        String f=field.get(0);
        sql+=f+"='";
        String m=f.substring(0,1).toUpperCase()+f.substring(1);
        m="get"+m;
        try {
            sql+=data.getClass().getMethod(m,null).invoke(data)+"'";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        jdbc.update(sql);

    }
    public void Find()
    {
        jdbc.query("select * from "+className);
        Type [] type =new Type[field.size()+1];
        String[] value = new String[field.size()+1];
        String  methodName;
        try{
            while (jdbc.getResultSet().next())
            {
                Object ojb= aClass.newInstance();
                for (int i=0;i<field.size();i++)
                {
                    type[i]=fields[i].getType();
                    String tt=type[i].getTypeName();
                    value[i]=jdbc.getResultSet().getString(field.get(i));
                    methodName=field.get(i).substring(0,1).toUpperCase()+field.get(i).substring(1);
                    methodName="set"+methodName;
                    if (type[i].getTypeName()=="int")
                    {
                        ojb.getClass().getMethod(methodName,int.class).invoke(ojb,Integer.parseInt(value[i]));
                    }
                    else
                        ojb.getClass().getMethod(methodName,String.class).invoke(ojb,value[i]);


                }
                list.add((T)ojb);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public boolean isReapt(T data)
    {
        for (int i=0;i<list.size();i++)
        {
            if (data.equals(list.get(i)))
                return true;
        }
        return  false;
    }


}
