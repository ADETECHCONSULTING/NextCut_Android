package traore.adama.nextcut_android.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.ui.MainActivity
import traore.adama.nextcut_android.ui.adapter.ExploreAdapter

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() : ProfileFragment{
            return ProfileFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


}
