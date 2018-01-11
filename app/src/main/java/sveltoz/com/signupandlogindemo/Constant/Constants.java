package sveltoz.com.signupandlogindemo.Constant;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by apple on 2/13/17.
 */

public class Constants {

    public static String baseUrl1 = "http://202.88.154.118/GroceryWebAPINew/api/Home/";

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public static void progressDialog(ProgressDialog progress, String title, String message) {
        progress.setTitle(title);
        progress.setMessage(message);
        progress.setCancelable(true); // disable dismiss by tapping outside of the dialog
        progress.show();

        progress.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //  showAlertDialog("Oops!", "Network connection is poor!");
            }
        });
    }


}
