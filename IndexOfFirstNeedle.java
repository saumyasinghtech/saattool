/**Program : ["java","python","java","php","java","python"]
 
output:
java - 3
python - 2
php - 1 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class IndexOfFirstNeedle {
    public static Map<String,Integer> findRepatedString(ArrayList<String> strings){
        Map<String,Integer> repatedMap = new HashMap<>();

        for(String str : strings){
            repatedMap.put(str,repatedMap.getOrDefault(str,0) + 1);
        }
        return repatedMap;  
    }
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("Java");
        list.add("PHP");
        list.add("Python");

        Map<String ,Integer> repated = findRepatedString(list);
        for(Map.Entry<String,Integer> entry : repatedMap.enrtySet()){
            System.out.println("Result "+entry.getKey());
        }
    }
}

/**[15:30] Komal Gajera
Program : ["java","python","java","php","java","python"]
 
output:
java - 3
python - 2
php - 1
 
 
sql query : 
1) write one join query.
2) write a query to find second
 highest value of salary in employee table.
 
JPA method:
find employee name start with a and salary greater tghen 20000.
  */

  1) select id,name,cityName from Student join City on Student.id=City.id; 

  2) Select Max(salary) from EmpTble where salary< (Select Max(salary) from EmpTble);
  
3) emplRepo.findEmployeeByNameStartingWithAAndSalaryGraterThan(20000);
