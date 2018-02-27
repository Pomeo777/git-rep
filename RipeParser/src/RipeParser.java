import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RipeParser {

	String outputFileName = "ip.txt";
	String[] mntArr = new String[] { "YANDEX-MNT", "VKONTAKTE-NET-MNT",
			"ODNOKLASSNIKI-WEB", "MNT-NETBRIDGE" };
	File outputFile;
	File inputFile;

	public static void main(String[] args) {

		RipeParser rp = new RipeParser();
		rp.inputFile = new File(args[0]);
		rp.outputFile = new File(rp.outputFileName);

		try {
			if (!rp.outputFile.exists())
				rp.outputFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (BufferedReader bufferedReader = new BufferedReader(
						new FileReader(rp.inputFile))) {

			String readedLine, stringFromBuffer;
			
			while (bufferedReader.ready()) {
				StringBuilder sb = new StringBuilder();
				
				while ((readedLine = bufferedReader.readLine()) != null) {
					if (readedLine.length() == 0) {
						break;
					}
					sb = sb.append(readedLine).append(" ").append("\r\n");
				}
			
				stringFromBuffer = sb.toString();
				if (stringFromBuffer.startsWith("inetnum")
						& stringFromBuffer.contains(" RU ")) {
					
					rp.search(stringFromBuffer, rp.outputFileName, rp.mntArr);

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	public boolean hasMNT(String mnt, String[] mntArr) {
		boolean result = false;
		for (String s : mntArr) {
			if (mnt.equals(s)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public void addToFile(String inetnum, String outputFileName) {

		try (FileWriter fw = new FileWriter(outputFileName, true)) {
			fw.write(inetnum);
			fw.append("\r\n");
			fw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public void search(String lineBloc, String outputFileName, String[] mntArr) {
		String inetnum = null;
		String[] parsLine;
		parsLine = lineBloc.split("\r\n");
		for (int i = 0; i < parsLine.length; i++) {

			String[] inerMass = parsLine[i].split(":");
			if(inerMass.length >= 2){
			inerMass[1] = inerMass[1].trim();

			if (inerMass[0].equals("inetnum")) {
				inetnum = inerMass[1];
			}
//			if(inerMass[0].equals("country")){
//				System.out.println(inerMass[1]);
//			}
			
//			if (inerMass[0].equals("country")) {
//				System.out.println(inerMass[0].equals("country"));
//				String country = inerMass[1];
//				System.out.println(country);
//				if (!country.equals("RU")) {
//
//					break;
//				}
//			}
			if (inerMass[0].equals("mnt-by")) {
				//System.out.println(inerMass[1]);
				if (hasMNT(inerMass[1], mntArr)) {
					System.out.println("in if");
					addToFile(inetnum, outputFileName);
					break;
				}
			}
			}
		}
	}

}
