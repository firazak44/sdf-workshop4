import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdExec {
    static String run(String cmdString) {
		String result = "";
		String line;
		try {
            Process child = Runtime.getRuntime().exec(parseCommand(cmdString));
            BufferedReader output = new BufferedReader(new InputStreamReader(child.getInputStream()));
            while ((line = output.readLine()) != null) {
				result = result.concat(line);
				result = result.concat("\n");
			}
            output.close();

        }catch(IOException e){
            e.printStackTrace();

        }
        return result;
    }
}