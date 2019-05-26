package traore.adama.nextcut_android.service.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import org.jetbrains.annotations.Nullable
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.database.NextCutDatabase
import traore.adama.nextcut_android.database.dao.NextcuterDao
import traore.adama.nextcut_android.database.model.Nextcuter
import java.util.*

class NextcuterRepository() {

    companion object {
        val instance = NextcuterRepository()
    }

    fun getNextcuters():LiveData<List<Nextcuter>>{
        val data = MutableLiveData<List<Nextcuter>>()

        val list = ArrayList<Nextcuter>()
        val random = Random()
        list.add(Nextcuter(1, random.nextInt(100), "Traore", "Adama", ""))
        list.add(Nextcuter(2, random.nextInt(100), "Eliko", "Elige", ""))
        list.add(Nextcuter(3, random.nextInt(100), "Traore", "Tali", ""))
        list.add(Nextcuter(4, random.nextInt(100), "Lori", "Evan",""))
        list.add(Nextcuter(5, random.nextInt(100), "Traore", "Adama", ""))
        list.add(Nextcuter(6, random.nextInt(100), "Eliko", "Elige", ""))
        list.add(Nextcuter(7, random.nextInt(100), "Traore", "Tali", ""))
        list.add(Nextcuter(8, random.nextInt(100), "Lori", "Evan", ""))
        list.add(Nextcuter(9, random.nextInt(100), "Traore", "Adama", ""))
        list.add(Nextcuter(10, random.nextInt(100), "Eliko", "Elige", ""))
        list.add(Nextcuter(11, random.nextInt(100), "Traore", "Tali", ""))
        list.add(Nextcuter(12, random.nextInt(100), "Lori", "Evan", ""))

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