package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class DesafioMap {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Consumer<Integer> print = System.out::println;
		
		UnaryOperator<String> inverter = 
				s -> new StringBuilder(s).reverse().toString();
				
		Function<String, Integer> binarioParaInt = 
				s -> Integer.parseInt(s, 2);
		
		nums.stream()
		.map(Integer::toBinaryString)
		.map(inverter)
		.map(binarioParaInt)
		.forEach(print);
				
	}

}
