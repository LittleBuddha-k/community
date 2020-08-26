package com.littlebuddha.community.stream.dosomething;

import com.littlebuddha.community.stream.data.Data;
import com.littlebuddha.community.stream.data.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoPerson {

    public static void main(String[] args) {
        //Person person = new Person();
        //person.setAge(18).setName("嚣张").setScore(99.5);//对一个数据源操作后返回数据源可以依次对数据源进行操作-------流式处理

        Stream<Person> stream = Data.getData().stream();//获取list数据流
        //List<Person> list = stream.collect(Collectors.toList());

        //Set<Person> list = stream.collect(Collectors.toSet());

        //Map<String, Double> map = stream.collect(Collectors.toMap(ele -> ele.getName(), ele -> ele.getScore()));//使用person的name作为key，score作为value生成map
        //System.out.println(map);

        //Stream<Integer> streamA = Stream.of(0,1,2,3,4,5,6,7,8,9);
        //Optional<Integer> result = streamA.reduce((a, b) -> a + b);
        //System.out.println(result.get());

        Optional<Person> reduce = stream.reduce((a, b) -> {
            Person person = new Person();
            return person.setScore(a.getScore() + b.getScore());
        });
        System.out.println(reduce.get());
    }
}
