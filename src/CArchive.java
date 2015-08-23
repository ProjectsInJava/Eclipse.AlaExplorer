import java.nio.file.attribute.FileTime;

public final class CArchive extends CFile
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
		
		public CArchive(float aLevelOfCompression,String aPassword,String aName, FileTime aDateOfCreate, String aLocation, long aSize,  EExtension aExtension)
		{

			super(aName,aDateOfCreate,aLocation,aSize,aExtension);
			mPassword = aPassword;
			mLevelOfCompression = aLevelOfCompression;
		}
	}