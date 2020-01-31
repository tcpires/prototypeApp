package application.network;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
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

    public static Firebase getFirebaseInstance() {
        return Holder.instance;
    }


    private Firebase() {
    }

    public static FirebaseAuth firebaseAuth;

    public static FirebaseAuth getAuthInstance() {
        if (firebaseAuth == null) {
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
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

    public DatabaseReference getDatabaseReference() {
        if (ref == null) {
            initFirebase();
        }
        return ref;
    }

}
