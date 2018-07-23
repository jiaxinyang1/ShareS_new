package MainPage;

import net.sf.json.JSONArray;

import java.util.List;

public class ToJSON {
    public  static  String toJson(List list)
    {
        JSONArray array= JSONArray.fromObject(list);
        return array.toString();

    }
}
