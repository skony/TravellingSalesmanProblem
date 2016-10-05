package pl.example;

public class Main {
	
	public static void main(String[] args) {
		FileToGraphReader fileToGraphReader = new FileToGraphReader();
		Graph graph = fileToGraphReader.read();
	}
}
