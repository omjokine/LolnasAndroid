package fi.lolnas;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

public class LocationService {
	//	private static final String FILENAME = "LOCATION";
	private static final String TAG = LocationService.class.getName();

	public synchronized static String getLocation(Context context) {
		LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(true);
		String strLocationProvider = lm.getBestProvider(criteria, true);

		Location location = lm.getLastKnownLocation(strLocationProvider);

		if(location != null) {
			StringBuffer locationString = new StringBuffer();
			locationString.append("latitude=");
			locationString.append(location.getLatitude());
			locationString.append("&longitude=");
			locationString.append(location.getLongitude());
			Log.d(TAG, "Got location: " + location.toString());
			return locationString.toString();
		}

		return "";
		//		File location = new File(context.getFilesDir(), FILENAME);
		//		try {
		//			if (!location.exists()) {
		//				updateLocation(context);
		//			}
		//			return readLocationFile(location);
		//		} catch (Exception e) {
		//			throw new RuntimeException(e);
		//		}
	}

	//	public synchronized static void updateLocation(Context context) {
	//		LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
	//
	//		Criteria criteria = new Criteria();
	//		criteria.setAccuracy(Criteria.ACCURACY_FINE);
	//		criteria.setAltitudeRequired(false);
	//		criteria.setBearingRequired(false);
	//		criteria.setCostAllowed(true);
	//		String strLocationProvider = lm.getBestProvider(criteria, true);
	//
	//		Location location = lm.getLastKnownLocation(strLocationProvider);
	//		if(location != null) {
	//			LocationService.setLocation(context, location.getLatitude(), location.getLongitude());
	//			Log.d(TAG, "Got location: " + location.toString());
	//		}
	//	}
	//
	//	private synchronized static void setLocation(Context context, double latitude, double longitude) {
	//		StringBuffer locationString = new StringBuffer();
	//		locationString.append("latitude=");
	//		locationString.append(latitude);
	//		locationString.append("&longitude=");
	//		locationString.append(longitude);
	//		File location = new File(context.getFilesDir(), FILENAME);
	//		try {
	//			writeLocationFile(location, locationString.toString());
	//		} catch (Exception e) {
	//			throw new RuntimeException(e);
	//		}
	//	}
	//
	//	private static String readLocationFile(File installation) throws IOException {
	//		RandomAccessFile f = new RandomAccessFile(installation, "r");
	//		byte[] bytes = new byte[(int) f.length()];
	//		f.readFully(bytes);
	//		f.close();
	//		return new String(bytes);
	//	}
	//
	//	private static void writeLocationFile(File installation, String locationString) throws IOException {
	//		FileOutputStream out = new FileOutputStream(installation);
	//		out.write(locationString.getBytes());
	//		out.close();
	//	}
}