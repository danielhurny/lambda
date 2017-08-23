package lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Main {

	public static void main(String[] args) {
        ListCreator listCreator = new ListCreator();
		List<String> test = createList();
		test.forEach(a -> System.out.println(a));

		test.forEach(System.out::print);
		System.out.println();
		test.forEach(a -> System.out.print(a.toUpperCase()));

		test.stream().map(name -> name.length()).filter(name -> name > 5).forEach(System.out::println);

		test.stream().filter(name -> name.startsWith("D")).map(name -> "skvelee")
				.forEach(name -> System.out.print(name));

		List<String> startsWithD = test.stream().filter(name -> name.startsWith("D")).collect(Collectors.toList());
		System.out.println(startsWithD);

		Optional<String> foundName = test.stream().filter(name -> name.startsWith("X")).findFirst();

		System.out.println(String.format("Word starting with D is: %s", foundName.orElse("No word found")));

		System.out.println("total numbers in all words: " + test.stream().mapToInt(name -> name.length()).sum());

		Optional<String> longestName = test.stream()
				.reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		longestName.ifPresent(System.out::println);

		System.out.println(test.stream().map(String::toUpperCase).collect(Collectors.joining(",,,")));
		String string = "dovolenka";
		string.chars().mapToObj(ch -> Character.valueOf(((char) ch))).forEach(System.out::println);

		Comparator<String> asscending = (name1, name2) -> name1.compareTo(name2);
		Comparator<String> desccending = asscending.reversed();
		List<String> ascending = test.stream().sorted(asscending).collect(Collectors.toList());
		System.out.println(ascending);

		test.stream().max((name1, name2) -> name1.length() - name2.length())
				.ifPresent(longest -> System.out.println(longest));
		try {
			System.out.println(listCreator.getClass().getField("listt").getType());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> createList() {
		ListCreator abc = new ListCreator();
		return abc.fillList();

	}

}
