package pop.uz.guidetour.webviewactivity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import pop.uz.guidetour.R;
import pop.uz.guidetour.enumnames.ParkNames;
import pop.uz.guidetour.ui.parks.ParkFragment;
import pop.uz.guidetour.ui.webviewfragment.WebViewParkFragment;

public class WebViewParkActivity extends AppCompatActivity {

  public static final String INTENT_PARK_NAME = "intent_park_name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey(INTENT_PARK_NAME)){
           ParkNames names = (ParkNames) bundle.getSerializable(INTENT_PARK_NAME);
            openFragment(WebViewParkFragment.newInstance(names));
        }
    }

    public void openFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.container_webview, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }
}
