import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;


public class GFX extends Activity{
	MyBrinkBack outView;
	WakeLock wL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		PowerManager pM=(PowerManager)getSystemService(Context.POWER_SERVICE);
	wL=pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "WTF");
		super.onCreate(savedInstanceState);
		wL.acquire();
		outView=new MyBrinkBack(this);
		setContentView(outView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wL.release();
	}
	
	

}
