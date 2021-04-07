import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
 
public class MapTest1 {
 
    public static void main(String[] args) {
        String[] people = {"Mike", "Anna", "Mike", "Harry"};
        Map<String, Integer> map = new HashMap<>();
        for(String a : people) {
        	System.out.println(map);
        	map.put(a, map.getOrDefault(a, 0) + 1);
        }
        System.out.println(map); //{Anna=1, Mike=2, Harry=1}
        
    	Map<String, String> map2 = new HashMap<String, String>();
		map2.put("k1", "siri");
		map2.put("k2", "sani");
		map2.put("k3", "사니");
		map2.put("k3", "최진실"); // 중복되는 키 값중 마지막 데이터가 덮어씀
		Set<String> s = map2.keySet();
		for(String a : s) {
			System.out.println(a);
		}
		Collection<String> col = map2.values();
		Iterator<String> it = col.iterator();

		System.out.println("<< 전체 map2데이터 >>");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("<< 전체 map2의 키 출력 >>");
		Set<String> set = map2.keySet();
		Iterator<String> keyset = set.iterator();
		while (keyset.hasNext()) {
			String key = keyset.next();
			System.out.println(key + "에 저장된 데이터 :" + map2.get(key));
		}
    }
}