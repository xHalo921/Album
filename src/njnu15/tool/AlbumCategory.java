package njnu15.tool;

import java.util.ArrayList;
import java.util.List;

public class AlbumCategory {
    private static List<String> list= new ArrayList<String>();
    static {
        list.add("校园");
        list.add("自然");
    }
    public static List<String> getAlbumCategory(){
        return list;
    }

    public static void addCategory(String s){
        list.add(s);
    }

    public static void delCategory(int i){
        list.remove(i);
    }
}
