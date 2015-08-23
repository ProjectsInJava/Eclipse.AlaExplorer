import java.nio.file.attribute.FileTime;

public final class CImage extends CFile
	{
		
		private String mAuthor;
		private CDimension mDimension;
		
		//property access methods
		
		public void setAuthor(String aAuthor)
		{
			mAuthor = aAuthor;
		}
		
		public String getAuthor()
		{
			return mAuthor;
		}
		
		public void setDimension(CDimension aDimension)
		{
			mDimension = aDimension;
		}
		
		public CDimension getDimension()
		{
			return mDimension;
		}
		
		public CImage(String aAuthor, CDimension aDimension ,String aName, FileTime aDateOfCreate, String aLocation, long aSize,  EExtension aExtension)
		{
			super(aName,aDateOfCreate,aLocation,aSize,aExtension);
			mAuthor = aAuthor;
			mDimension = aDimension;
		}
		
		public CImage(CDimension aDimension ,String aName, FileTime aDateOfCreate, String aLocation, long aSize,  EExtension aExtension)
		{
			super(aName,aDateOfCreate,aLocation,aSize,aExtension);
			mDimension = aDimension;
			mAuthor = "";

		}		
	}

