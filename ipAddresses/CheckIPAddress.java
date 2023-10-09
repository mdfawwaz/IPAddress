package ipAddresses;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CheckIPAddress {
	
	
	private static String extractIpAdresses(String input) {
		Pattern pattern = Pattern.compile("(\\b25[0-5] | \\b2[0-4][0-9] | \\b[01]?[0-9][0-9]?)"
				+ "(\\.(25[0-5] | 2[0-4] [0-9] | [01]?[0-9] [0-9]?)){3}\\b");
				
		Matcher matcher  = pattern.matcher(input);
		return matcher.results().map(result -> result.group()).collect(Collectors.joining(" "));
	}
	
	public static void main(String[] args) {
		
		Path source = Path.of("/home/fawwaz/");
		Path target = Path.of("/home/fawwaz/");	
		
		try {
			
			List<String> lines = Files.readAllLines(source);
			List<String> ips = lines.stream()
					.map(line -> extractIpAdresses(line))
					.collect(Collectors.toList());
			
			Files.write(target, ips);
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
}