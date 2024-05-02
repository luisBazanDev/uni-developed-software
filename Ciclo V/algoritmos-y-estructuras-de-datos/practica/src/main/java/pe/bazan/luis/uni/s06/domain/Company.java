package pe.bazan.luis.uni.s06.domain;

public class Company {
	private String name;
	private String CEOName;
	private int sinceYear;

	public Company(String name, String CEOName, int sinceYear) {
		this.name = name;
		this.CEOName = CEOName;
		this.sinceYear = sinceYear;
	}

	@Override
	public String toString() {
		return "Company{" +
				"name='" + name + '\'' +
				", CEOName='" + CEOName + '\'' +
				", sinceYear=" + sinceYear +
				'}';
	}
}
