import java.nio.file.attribute.FileTime;

	public final class CSound extends CFile
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
		
		public CSound(int i,String aName, FileTime aDateOfCreate, String aLocation, long aSize,  EExtension aExtension)
		{
			super(aName, aDateOfCreate, aLocation, aSize, aExtension);
			mBitrate = i;
			mAlbum = "";
		}
	}