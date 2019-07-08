package traore.adama.nextcut_android.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import traore.adama.nextcut_android.database.model.Haircut
import java.util.*

class HaircutRepository() {

    companion object {
        val instance = HaircutRepository()
    }

    fun getHaircuts():LiveData<List<Haircut>>{
        val data = MutableLiveData<List<Haircut>>()


        val list = ArrayList<Haircut>()

        val haircut1 = Haircut(1,
            "https://www.menshairstyletrends.com/wp-content/uploads/2018/01/barbernathen-buzz-cut-low-bald-fade-line-up.jpg",
            "Low Bald Fade")

        val haircut2 = Haircut(2,
            "https://www.menshairstyletrends.com/wp-content/uploads/2018/01/santanaalisson-low-fade-haircuts-side-part-combover.jpg",
            "Side Part")

        val haircut3 = Haircut(3,
            "https://www.menshairstyletrends.com/wp-content/uploads/2018/01/barbertwo-mid-bald-fade-haircut-medium-fade.jpg",
            "Medium Fade")

        val haircut4 = Haircut(4,
            "https://www.menshairstyletrends.com/wp-content/uploads/2018/01/barber.josh_.o.p-high-fade-haircut-sweep-back-shaved-line-2018.jpg",
            "Pompadour Fade")

        list.add(haircut1)
        list.add(haircut2)
        list.add(haircut3)
        list.add(haircut4)

        data.value = list

        return data
    }
}

/*

Sample with callback
public class ProjectRepository {
    private GitHubService gitHubService;

    //…

    public LiveData<List<Project>> getProjectList(String userId) {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        gitHubService.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                data.setValue(response.body());
            }

            // Error handling will be explained in the next article …
        });

        return data;
    }

    // …
}

 */