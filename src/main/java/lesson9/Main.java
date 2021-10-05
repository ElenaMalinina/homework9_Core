package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
//2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
//3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Joe", Arrays.asList(new Course("C++"), new Course("Java"), new Course("PHP"))));
        studentList.add(new Student("Mike", Arrays.asList(new Course("Ruby"), new Course("Java"), new Course("PHP"), new Course("Python"))));
        studentList.add(new Student("lisa", Arrays.asList(new Course("Python"), new Course("C++"))));
        studentList.add(new Student("Mary", Arrays.asList(new Course("Ruby"), new Course("Java"), new Course("C++"), new Course("Python"), new Course("PHP"))));

        System.out.println("Курсы :\n" + studentList.stream()
        .map(s -> s.getCourses())
        .flatMap(c -> c.stream())
        .collect(Collectors.toSet()));

        System.out.println("Cамые любознательные студенты: \n" + studentList.stream()
        .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
        .limit(2)
        .collect(Collectors.toList()));

        Course course = new Course("Ruby");
        List<Student> studentList1 = studentList.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList());
        System.out.println("Курс " + course + "посещают: \n" + studentList1);

    }
}
