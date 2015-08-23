import java.nio.file.attribute.FileTime;



public abstract class CFile
	{
		private String mName;
		private FileTime mDateOfCreate; // data
		private String mLocation;
		private long mSize;
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
		
		public void setSize( long aSize )
		{
			mSize = aSize;
		}
		
		public long getSize()
		{
			return mSize;
		}
		
		public void setDateOfCreate( FileTime aDateOfCreate)
		{
			mDateOfCreate = aDateOfCreate;
		}
		
		public FileTime getDateOfCreate()
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
		
		public CFile(String aName, FileTime aDateOfCreate, String aLocation, long aSize,  EExtension aExtension)
		{
			mName = aName;
			mDateOfCreate = aDateOfCreate;
			mSize = aSize;
			mExtension = aExtension;
			mLocation=aLocation;
		}
	}