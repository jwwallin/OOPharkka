package run;

import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.io.IOException;

public class Start {

	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		
		System.out.println(ansi().bg(WHITE).eraseScreen().fg(RED).a("Hello ").fg(YELLOW).a("World").reset());
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnsiConsole.systemUninstall();

	}

}
