import java.nio.file.attribute.FileTime;

public final class CDocument extends CFile
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
		
		public CDocument(int aAmountOfPages, String aPassword,String aName, FileTime aDateOfCreate, String aLocation, long aSize,  EExtension aExtension)
		{
			super(aName, aDateOfCreate, aLocation, aSize, aExtension);
			mAmountOfPages = aAmountOfPages;
		}
		
	}