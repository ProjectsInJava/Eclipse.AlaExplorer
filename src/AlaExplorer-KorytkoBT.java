
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;  
import javax.swing.JFileChooser;


public class AlaExplorer 
{

	public static Path openAndGetPath()
	{
		final JFileChooser newFile = new JFileChooser();
		int returnVal = newFile.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) 
	    {
	       System.out.println("You chose to open this file: " +
	            newFile.getSelectedFile().getName());
	    }
	    
	    return newFile.getSelectedFile().toPath();
	}
	public static String getExtensionOfFile(String aPathOfFile)
	{
		String FileWithExtension = aPathOfFile.substring(aPathOfFile.lastIndexOf(".")+1);		
		return FileWithExtension.toUpperCase();
	}
	public static int IdOfFile = 0;
	
	public static void main(String args[])
	{
		final int NumOfFiles = 50;
		String ExtensionOfFile;
		Path PathOfFile;
		EExtension ExtensionToChoose;
		
		ArrayList <CFile> oArrayOfObjects = new ArrayList(NumOfFiles);
		GregorianCalendar Today = new GregorianCalendar();	
		
		System.out.println("Witam w programie odczytuj¹cym parametry pliku oraz tworz¹cym klasê dla niego");
		System.out.println("Teraz otwórz plik");
		
		PathOfFile = openAndGetPath();
		
		//pobieranie rozszerzenia
		ExtensionOfFile = getExtensionOfFile(PathOfFile.toString());		
		ExtensionToChoose = EExtension.valueOf(ExtensionOfFile);
		
		
		BasicFileAttributes attr;
		try {			
			attr = Files.readAttributes(PathOfFile, BasicFileAttributes.class);
			Files.
			
			switch(ExtensionToChoose)
			{
			case JPG:
				System.out.println("Tworze obiekt klasy CImage");
				oArrayOfObjects.add(IdOfFile,new CImage(new CDimension(200,300),
						PathOfFile.getFileName().toString(),
						attr.creationTime(),
						PathOfFile.toString(),
						attr.size(),
						ExtensionToChoose));
				++IdOfFile;
				
				System.out.println("Name of File: " + oArrayOfObjects.get(0).getName());
				System.out.println("Size of File in bytes: " + oArrayOfObjects.get(0).getSize());
				System.out.println("Date of Create that File: " + oArrayOfObjects.get(0).getDateOfCreate());
				System.out.println("Location of File in: " + oArrayOfObjects.get(0).getLocation());
				System.out.println("Extension of File : " + oArrayOfObjects.get(0).getExtension());
				break;
			case MP3:
				//tworze plik CImage
				break;
			case PDF:
				// tworze plik cDocument
				break;
			case RAR:
				//tworze CArchive
				break;
			default:
				//nie mam klasy dla tego pliku
				
			}
					
				
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("wyjatek");
			e.printStackTrace();
		}
		

		//

		
		
		// odczytywanie atrybutów plików odczytanych
		
		//System.out.println(getExtensionOfFile(openAndGetPath()));


		

				// to wszystko na dole bêdzie u¿yte
		
		//newArrayList.add(new CImage("Korytko", new SDIMENSION(60,40), "MyPicture", Today.getTime(), "C://MyDocuments", 1024F, EExtension.JPG));
		//newArrayList.add(new CArchive(0.95F, "zaq1@WSX", "MyArchive",Today.getTime(), "C://MyDocuments", 1024F, EExtension.RAR));
		/*
		for(CFile i: newArrayList)
		{
			System.out.println(i.mName);// wyswietlam nazwy plikow 
		}
		*/
		
		//teraz trzeba zrobic tak aby mozna bylo sie tez dostaæ do samych plikow
		
		//CImage nowyObrazek = (CImage)newArrayList.get(0);
		short zmienna = 25;
		//CSound nowyplikmuzyczny = new CSound(30,"newMusic",Today.getTime(),"C://Music",2048F,EExtension.MP3);
		
		


		
	}
	
}
