package alabs.gsheetwithimage;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static alabs.gsheetwithimage.Configuration.KEY_DATE;
import static alabs.gsheetwithimage.Configuration.KEY_ID;
import static alabs.gsheetwithimage.Configuration.KEY_IMAGE;
import static alabs.gsheetwithimage.Configuration.KEY_JAT;
import static alabs.gsheetwithimage.Configuration.KEY_JUMLAH;
import static alabs.gsheetwithimage.Configuration.KEY_MEREK;
import static alabs.gsheetwithimage.Configuration.KEY_USERS;


public class JsonParser {
    public static String[] NomorSpesifiks;
    public static String[] JenisAsetTetaps;
    public static String[] Mereks;
    public static String[] Spesifikasis;
    public static String[] Jumlahs;
    public static String[] Tahuns;
    public static String[] Gambars;


    private JSONArray users = null;

    private String json;

    public JsonParser(String json) {
        this.json = json;
    }

    protected void parseJSON() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(KEY_USERS);

            NomorSpesifiks = new String[users.length()];
            JenisAsetTetaps = new String[users.length()];
            Mereks = new String[users.length()];
            Spesifikasis = new String[users.length()];
            Jumlahs = new String[users.length()];
            Tahuns = new String[users.length()];
            Gambars = new String[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                NomorSpesifiks[i] = jo.getString(KEY_ID);
                JenisAsetTetaps[i] = jo.getString(KEY_JAT);
                Mereks[i] = jo.getString(KEY_MEREK);
                Jumlahs[i] = jo.getString(KEY_JUMLAH);
                Tahuns[i] = jo.getString(KEY_DATE);
                Gambars[i] = jo.getString(KEY_IMAGE);
            }

            Log.e("Gambar", "ser image" + Gambars[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
