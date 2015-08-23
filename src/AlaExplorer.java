import java.awt.Component;
import java.awt.FileDialog;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;  

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class AlaExplorer 
{
	public static enum EExtension
	{
		JPG,
		RAR,
		PDF,
		MP3,
		EMPTY;
	}
	
	public static class SDIMENSION
	{
		int mHeight;
		int mWeight;
		
		public SDIMENSION(int aHeight, int aWeight)
		{
			mHeight = aHeight;
			mWeight = aWeight;
		}
	}
	
	public abstract static class CFile
	{
		private String mName;
		private Date mDateOfCreate; // data
		private String mLocation;
		private float mSize;
		private static EExtension mExtension;
		
		
		
		//Getters And Setters of Class
		public void setName(String aName)
		{
			aName = mName;
		}
		
		public String getName()
		{
			return mName;
		}
		
		public void setLocation(String aLocation)
		{
			mLocation = aLocation;
		}
		
		public String getLocation()
		{
			return mLocation;
		}
		
		public void setSize( float aSize )
		{
			mSize = aSize;
		}
		
		public float getSize()
		{
			return mSize;
		}
		
		public void setDateOfCreate( Date aDateOfCreate)
		{
			mDateOfCreate = aDateOfCreate;
		}
		
		public Date getDateOfCreate()
		{
			return mDateOfCreate;
		}
		
		public void setExtension( EExtension aExtension)
		{
			mExtension = aExtension;
		}
		
		public EExtension getExtension()
		{
			return mExtension;
		}
		
		public CFile(String aName, Date aDateOfCreate, String aLocation, float aSize,  EExtension aExtension)
		{
			mName = aName;
			mDateOfCreate = aDateOfCreate;
			mSize = aSize;
			mExtension = aExtension;
			mLocation=aLocation;
		}
	}

	public final static class CImage extends CFile
	{
		
		private String mAuthor;
		private SDIMENSION mDimension;
		
		//property access methods
		
		public void setAuthor(String aAuthor)
		{
			mAuthor = aAuthor;
		}
		
		public String getAuthor()
		{
			return mAuthor;
		}
		
		public void setDimension(SDIMENSION aDimension)
		{
			mDimension = aDimension;
		}
		
		public SDIMENSION getDimension()
		{
			return mDimension;
		}
		
		public CImage(String aAuthor, SDIMENSION aDimension ,String aName, Date aDateOfCreate, String aLocation, float aSize,  EExtension aExtension)
		{
			super(aName,aDateOfCreate,aLocation,aSize,aExtension);
			mAuthor = aAuthor;
			mDimension = aDimension;
		}
		
		public CImage(SDIMENSION aDimension ,String aName, Date aDateOfCreate, String aLocation, float aSize,  EExtension aExtension)
		{
			super(aName,aDateOfCreate,aLocation,aSize,aExtension);
			mDimension = aDimension;
			mAuthor = "";

		}		
	}
	public final static class CArchive extends CFile
	{
		private float mLevelOfCompression ;
		private String mPassword;
		
		//property access methods
		
		public void setLevelOfCompression( float aLevelOfCompression )
		{
			mLevelOfCompression = aLevelOfCompression;
		}
		public float getLevelOfCompression()
		{
			return mLevelOfCompression;
		}
		
		public void setPassword ( String aPassword )
		{
			mPassword = aPassword;			
		}
		public String getPassword()
		{
			return mPassword;
		}
		
		public CArchive(float aLevelOfCompression,String aPassword,String aName, Date aDateOfCreate, String aLocation, float aSize,  EExtension aExtension)
		{

			super(aName,aDateOfCreate,aLocation,aSize,aExtension);
			mPassword = aPassword;
			mLevelOfCompression = aLevelOfCompression;
		}
	}
	public final static class CDocument extends CFile
	{
		private int mAmountOfPages;
		
		//property access methods
		public void setAmountOfPages( int aAmountOfPages )
		{
			mAmountOfPages = aAmountOfPages;
		}
		public int getAmountOfPages()
		{
			return mAmountOfPages;
		}
		//constructor
		
		public CDocument(int aAmountOfPages, String aPassword,String aName, Date aDateOfCreate, String aLocation, float aSize,  EExtension aExtension)
		{
			super(aName, aDateOfCreate, aLocation, aSize, aExtension);
			mAmountOfPages = aAmountOfPages;
		}
		
	}
	public final static class CSound extends CFile
	{
		private int mBitrate;
		private String mAlbum;
		
		//property access methods
		public void setBitrate( short aBitrate )
		{
			mBitrate = aBitrate;
		}
		public int getBitrate()
		{
			return mBitrate;
		}
		
		public void setAlbum ( String aAlbum)
		{
			mAlbum = aAlbum;
		}
		public String getAlbum ()
		{
			return mAlbum;
		}
		
		public CSound(int i,String aName, Date aDateOfCreate, String aLocation, float aSize,  EExtension aExtension)
		{
			super(aName, aDateOfCreate, aLocation, aSize, aExtension);
			mBitrate = i;
			mAlbum = "";
		}
	}
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
	public static void main(String args[])
	{
		final int NumOfFiles = 50;
		String ExtensionOfFile;
		Path PathOfFile;
		EExtension ExtensionToChoose;
		
		ArrayList <CFile> newArrayList = new ArrayList(NumOfFiles);
		GregorianCalendar Today = new GregorianCalendar();	
		
		System.out.println("Witam w programie odczytuj¹cym parametry pliku oraz tworz¹cym klasê dla niego");
		System.out.println("Teraz otwórz plik");
		
		PathOfFile = openAndGetPath();
		
		//switch rozszerzenia parsowanego ze stringa 
		ExtensionOfFile = getExtensionOfFile(PathOfFile.toString());		
		ExtensionToChoose = EExtension.valueOf(ExtensionOfFile);
		
		
		BasicFileAttributes attr;
		try {			
			attr = Files.readAttributes(PathOfFile, BasicFileAttributes.class);
			
			switch(ExtensionToChoose)
			{
			case JPG:
				System.out.println("Tworze obiekt klasy CImage");
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

		*/
		
		// odczytywanie atrybutów plików odczytanych
		
		//System.out.println(getExtensionOfFile(openAndGetPath()));


		

				// to wszystko na dole bêdzie u¿yte
		
		newArrayList.add(new CImage("Korytko", new SDIMENSION(60,40), "MyPicture", Today.getTime(), "C://MyDocuments", 1024F, EExtension.JPG));
		newArrayList.add(new CArchive(0.95F, "zaq1@WSX", "MyArchive",Today.getTime(), "C://MyDocuments", 1024F, EExtension.RAR));
		/*
		for(CFile i: newArrayList)
		{
			System.out.println(i.mName);// wyswietlam nazwy plikow 
		}
		*/
		
		//teraz trzeba zrobic tak aby mozna bylo sie tez dostaæ do samych plikow
		
		CImage nowyObrazek = (CImage)newArrayList.get(0);
		short zmienna = 25;
		CSound nowyplikmuzyczny = new CSound(30,"newMusic",Today.getTime(),"C://Music",2048F,EExtension.MP3);
		
		


		
	}
	
}
