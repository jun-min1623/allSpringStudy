package streamAndLambda;

import java.util.*;
import java.util.stream.Stream;

@FunctionalInterface
interface MyLambdaFunction {
    int max(int a, int b);
}

public class Lambda {

    public static void main(String[] args) {

        // 람다식을 이용한 익명함수
        MyLambdaFunction lambdaFunction = (int a, int b) -> a > b ? a : b;
        MyLambdaFunction lambdaFunction1 = (int b, int c) -> c > b ? c : b;
        System.out.println(lambdaFunction.max(3, 5));
        System.out.println(lambdaFunction1.max(3, 5));

        Stream.builder();
    }

}