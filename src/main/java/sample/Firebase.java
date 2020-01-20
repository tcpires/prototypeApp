package sample;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Firebase {

    private DatabaseReference ref;

    private static class Holder {
        static final Firebase instance = new Firebase();
    }

    private Firebase() {
    }

    public static Firebase getInstance() {
        return Holder.instance;
    }

    public void initFirebase() {

        FileInputStream serviceAccount = null;
        FirebaseOptions options = null;

        try {
            serviceAccount = new FileInputStream("churchcontrol-f48b1-firebase-adminsdk-x9y7u-eb7d609a0e.json");
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://churchcontrol-f48b1.firebaseio.com/")
                    .build();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        FirebaseApp.initializeApp(Objects.requireNonNull(options));
         ref = FirebaseDatabase.getInstance().getReference();
    }
    public DatabaseReference getDatabaseReference(){
        if(ref == null){
            initFirebase();
        }
        return ref;
    }

}