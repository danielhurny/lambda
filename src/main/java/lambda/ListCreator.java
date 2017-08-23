package lambda;

import java.util.ArrayList;
import java.util.List;

public class ListCreator {
	public List<String> listt;

	public ListCreator() {
		super();
		this.listt = listt;
	}

	public List<String> getList() {
		return listt;
	}

	public void setList(List<String> list) {
		this.listt = list;
	}

	public List<String> fillList() {
		listt = new ArrayList<>();
		listt.add("Anna");
		listt.add("Beata");
		listt.add("Cindy");
		listt.add("Daniel");
		listt.add("Emil");
		listt.add("Frantisek");
		listt.add("Gustav");
		listt.add("Hugo");

		return listt;
	}

}
