package Model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {

    List<Integer> list = Arrays.asList(34,654,677,3,4,56,22,87,56,7845,45,34);
    List<String> list1 = Arrays.asList("animesh","vikram","shrinath","rishikesh","omkar","animesh");

        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("animesh","rishikesh"),
                                                       Arrays.asList("omkar","vaibhav"),
                                                       Arrays.asList("vikram","shrinath"));

        List<Integer[]> listOfArrays = Arrays.asList(new Integer[]{2,3,4,5},
                                                        new Integer[]{5,6,7,8},
                                                       new Integer[]{77,45,34,23});
//
//        Map<Integer,String> map = new HashMap<>();
//
//        map.put(1,"animesh");
//        map.put(2,"ranjeet");
//        map.put(3,"pratik");
//        map.put(4,"vikram");
//        map.put(5,"shreenath");
//        map.put(6,"omkar");
//
//      //map.entrySet()  returns set of "(Map.Entry<Integer,String>)" elements which we assign to "entryset" variable
//      Set<Map.Entry<Integer,String>> entryset = map.entrySet();
//
//      for (Map.Entry<Integer,String> e : entryset )
//      {
//
//          System.out.println(e);
//
//      }

        //here we are creating two dimensional Object array which is array of arrays. we take 'Object' array bcoz later
        //when we convert this to Map through Stream, we dont have to worry about data types of key and values which we will
        //pass as arguments in 'Collectors.toMap()' method
        Object [][] arr = {{1,"animesh"},{2,"vikram"},{3,"shreenath"},{4,"swapnil"},{5,"ranjeet"},{6,"shambhuraj"}};

     Map<Integer,String> map =  Stream.of(arr)
             //here 's' represents arrays inside Object array such as "s => {1,"animesh"}"
             //here, we take two args bcoz we have to store key value pairs in map
                                    //passed as key         //passed as value
              .collect(Collectors.toMap(s -> (Integer) s[0],s -> (String) s[1]));

        //System.out.println(map);

       //here, we have used 'Stream' api on our hashmap named as 'map' which we have instantiated above
       //here, we used 'map.entrySet()' method which returns 'Set<Map.Entry<Integer,String>> set' and we convert this set to
       //stream and apply further conditions using stream api's method.
        //HashMap vrti stream api vaprycha asel tr tyachya entry et vr vapar i.e. 'hashmap.entrySet()' hya set vrr vapar
       Map<Integer,String> filteredMap = map.entrySet()
       .stream()
       .filter(s-> s.getKey() > 3)
       .filter(s -> s.getValue().startsWith("s"))
       .collect(Collectors.toMap(s-> s.getKey(),s->s.getValue() + "yz"));


        System.out.println(filteredMap);

        List <String> list = map.entrySet()
                .stream()
                .collect(Collectors.toList())



//
  // boolean value =  list1.stream()
   // .anyMatch(s->s.startsWith("a"));
     //   System.out.println(value);

//        Long value = list1.stream()
//                .count();
//        System.out.println(value);

//        Stream<String> str = list1.stream();
//        Stream<String> str1 = list2.stream();
//
//        Stream<String> con = Stream.concat(str1,str);
//        con.forEach(s -> System.out.println(s));

//       List<String> distinctList = list1.stream()
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(distinctList);

//          List<String> ls= list1.stream()
//               .filter(s -> s.length()>7)
//                .collect(Collectors.toList());
//        System.out.println(ls);

//            Optional<String> opt =list1.stream()
//                    .findAny();
//        System.out.println(opt);
//
//      List<String> flattenedList =  listOfLists.stream().flatMap(ls->ls.stream())
//                             .collect(Collectors.toList());
//
//        System.out.println(flattenedList);
//
//       List<Integer> fList = (List<Integer>) listOfArrays.stream().flatMap(ls-> Arrays.stream(ls)).collect(Collectors.toList());
//       System.out.println(fList);

//        list1.stream()
//               .forEach(s -> System.out.println(s));

   //       list1.stream().skip(2).limit(2).forEach(s-> System.out.println(s));

      //  list1.stream().sorted().forEach(s-> System.out.println(s));

    //    list1.stream().sorted((s1,s2)->s2.compareTo(s1)).forEach(s-> System.out.println(s));

    //     list1.stream().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int num =7;
//
//        for (int i =2;i<=n;i++)
//        {
//
//            num = (num*2)+5;
//
//        }
//
//        System.out.println("desired number is "+num);



    }

}
